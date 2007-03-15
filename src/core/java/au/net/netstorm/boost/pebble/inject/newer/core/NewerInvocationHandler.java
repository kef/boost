package au.net.netstorm.boost.pebble.inject.newer.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import au.net.netstorm.boost.pebble.core.PebbleProviderEngine;

public final class NewerInvocationHandler implements InvocationHandler {
    private PebbleProviderEngine pebbleProvider;
    private Class implClass;

    public NewerInvocationHandler(PebbleProviderEngine pebbleProvider, Class implClass) {
        this.pebbleProvider = pebbleProvider;
        this.implClass = implClass;
    }

    public Object invoke(Object object, Method method, Object[] params) throws Throwable {
        return pebbleProvider.provide(implClass, params);
    }
}
