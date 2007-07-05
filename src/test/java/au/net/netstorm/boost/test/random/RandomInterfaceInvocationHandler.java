package au.net.netstorm.boost.test.random;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.test.specific.SpecificProviderRegistry;

final class RandomInterfaceInvocationHandler implements InvocationHandler {
    private final EdgeClass classer = new DefaultEdgeClass();
    private final Map priorCalls = new HashMap();
    private final Class proxiedType;
    private final RandomProvider randomProvider;
    private final SpecificProviderRegistry specificProviders;

    // FIX 2076 Add in SpecificProviderRegistry here.
    public RandomInterfaceInvocationHandler(Class proxiedType, RandomProvider randomProvider, SpecificProviderRegistry specificProviders) {
        this.proxiedType = proxiedType;
        this.randomProvider = randomProvider;
        this.specificProviders = specificProviders;
    }

    public Object invoke(Object ref, Method method, Object[] params) throws Throwable {
        // FIX 2076 Invocation still an appropriate name????
        Invocation invocation = new Invocation(method, params);
        return invoke(ref, invocation);
    }

    private Object invoke(Object ref, Invocation invocation) {
        if (priorCalls.containsKey(invocation)) return priorCalls.get(invocation);
        Object result = provide(ref, invocation);
        priorCalls.put(invocation, result);
        return result;
    }

    private Object provide(Object ref, Invocation invocation) {
        Method method = invocation.getMethod();
        Object[] params = invocation.getParams();
        if (isEquals(method))
            return doEquals(ref, params[0]);
        if (isToString(method))
            return doToString();
        return provide(method);
    }

    private Object provide(Method method) {
        Class returnType = method.getReturnType();
        boolean specific = specificProviders.contains(returnType);
        return specific ? specificProviders.get(returnType) : randomProvider.get(returnType);
    }

    private boolean isToString(Method method) {
        return same(method, "toString", new Class[]{});
    }

    private boolean isEquals(Method method) {
        return same(method, "equals", new Class[]{Object.class});
    }

    private boolean same(Method method, String methodName, Class[] parameterTypes) {
        Method toString = classer.getMethod(Object.class, methodName, parameterTypes);
        return method.equals(toString);
    }

    private Object doEquals(Object object, Object otherObject) {
        return Boolean.valueOf(object == otherObject);
    }

    private Object doToString() {
        Object randomInt = randomProvider.get(Integer.class);
        return "Dummy proxy for <" + proxiedType + " (" + randomInt + ")>";
    }
}
