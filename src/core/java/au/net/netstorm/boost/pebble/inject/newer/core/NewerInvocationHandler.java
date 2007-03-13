package au.net.netstorm.boost.pebble.inject.newer.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public final class NewerInvocationHandler implements InvocationHandler {
    private ObjectProvider objectProvider;
    private Class implClass;

    public NewerInvocationHandler(ObjectProvider objectProvider, Class implClass) {
        this.objectProvider = objectProvider;
        this.implClass = implClass;
    }

    public Object invoke(Object object, Method method, Object[] params) throws Throwable {
        return objectProvider.provide(implClass, params);
    }
}
