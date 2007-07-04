package au.net.netstorm.boost.test.random;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

final class RandomInterfaceInvocationHandler implements InvocationHandler {
    private RandomProvider randomProvider;

    public RandomInterfaceInvocationHandler(RandomProvider randomProvider) {
        this.randomProvider = randomProvider;
    }

    public Object invoke(Object object, Method method, Object[] objects) throws Throwable {
        Class returnType = method.getReturnType();
        return randomProvider.get(returnType);
    }
}
