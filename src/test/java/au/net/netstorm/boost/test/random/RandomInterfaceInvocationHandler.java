package au.net.netstorm.boost.test.random;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

final class RandomInterfaceInvocationHandler implements InvocationHandler {
    private final Class proxiedType;
    private final RandomProvider randomProvider;
    private final Map results = new HashMap();

    // FIX 2076 Add in SpecificProviderRegistry here.
    public RandomInterfaceInvocationHandler(Class proxiedType, RandomProvider randomProvider) {
        this.proxiedType = proxiedType;
        this.randomProvider = randomProvider;
    }

    public Object invoke(Object object, Method method, Object[] objects) throws Throwable {
        Invocation invocation = new Invocation(object, method, objects);
        Object result = results.get(invocation);
        if (result != null) return result;
        return createAndRecordResult(invocation);
    }

    private Object createAndRecordResult(Invocation invocation) {
        Object result = createResult(invocation);
        results.put(invocation, result);
        return result;
    }

    private Object createResult(Invocation invocation) {
        Method method = invocation.getMethod();
        Object[] params = invocation.getParams();
        Object invoked = invocation.getInvoked();
        if (isEqualsMethod(method))
            return doEquals(invoked, params[0]);
        if (isToStringMethod(method))
            return doToString();
        return createRandomResult(method);
    }

    private Object createRandomResult(Method method) {
        Class returnType = method.getReturnType();
        return randomProvider.get(returnType);
    }

    private boolean isEqualsMethod(Method method) {
        if (!method.getName().equals("equals"))
            return false;
        return hasOneParameterOfTypeObject(method);
    }

    private boolean isToStringMethod(Method method) {
        return isMethodWithNoParams(method, "toString");
    }

    private boolean isMethodWithNoParams(Method method, String methodName) {
        if (!method.getName().equals(methodName))
            return false;
        return hasNoParameter(method);
    }

    private boolean hasOneParameterOfTypeObject(Method method) {
        Class[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length != 1)
            return false;
        Class parameterType = parameterTypes[0];
        return parameterType.equals(Object.class);
    }

    private boolean hasNoParameter(Method method) {
        return method.getParameterTypes().length == 0;
    }

    private Object doEquals(Object object, Object otherObject) {
        return Boolean.valueOf(object == otherObject);
    }

    private Object doToString() {
        Object randomInt = randomProvider.get(Integer.class);
        return "Dummy proxy for <" + proxiedType + " (" + randomInt + ")>";
    }
}
