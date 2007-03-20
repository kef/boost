package au.net.netstorm.boost.pebble.inject.newer.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import au.net.netstorm.boost.pebble.core.PebbleProviderEngine;
import au.net.netstorm.boost.util.type.Implementation;

public final class NewerInvocationHandler implements InvocationHandler {
    private PebbleProviderEngine pebbleProvider;
    private Implementation impl;

    public NewerInvocationHandler(PebbleProviderEngine pebbleProvider, Implementation impl) {
        this.pebbleProvider = pebbleProvider;
        this.impl = impl;
    }

    public Object invoke(Object object, Method method, Object[] params) throws Throwable {
        return pebbleProvider.provide(impl, params);
    }
}
