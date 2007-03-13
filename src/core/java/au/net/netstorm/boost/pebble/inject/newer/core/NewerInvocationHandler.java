package au.net.netstorm.boost.pebble.inject.newer.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import au.net.netstorm.boost.pebble.core.PebbleProvider;

public final class NewerInvocationHandler implements InvocationHandler {
    private PebbleProvider pebbleProvider;
    private Class implClass;

    public NewerInvocationHandler(PebbleProvider pebbleProvider, Class implClass) {
        this.pebbleProvider = pebbleProvider;
        this.implClass = implClass;
    }

    public Object invoke(Object object, Method method, Object[] params) throws Throwable {
        return pebbleProvider.provide(implClass, params);
    }
}
