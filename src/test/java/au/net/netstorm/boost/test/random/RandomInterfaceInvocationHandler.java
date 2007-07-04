package au.net.netstorm.boost.test.random;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

final class RandomInterfaceInvocationHandler implements InvocationHandler {
    private RandomProvider randomProvider;
    private Map results = new HashMap();

    public RandomInterfaceInvocationHandler(RandomProvider randomProvider) {
        this.randomProvider = randomProvider;
    }

    public Object invoke(Object object, Method method, Object[] objects) throws Throwable {
        Object result = results.get(method);
        if (result != null) return result;
        return maintainResult(method);
    }

    private Object maintainResult(Method method) {
        Object result = createResult(method);
        results.put(method, result);
        return result;
    }

    private Object createResult(Method method) {
        Class returnType = method.getReturnType();
        return randomProvider.get(returnType);
    }
}
