package au.net.netstorm.boost.pebble.inject.newer.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import au.net.netstorm.boost.pebble.core.ProviderEngine;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class NewerInvocationHandler implements InvocationHandler {
    private ProviderEngine provider;
    private Implementation impl;

    public NewerInvocationHandler(ProviderEngine provider, Implementation impl) {
        this.provider = provider;
        this.impl = impl;
    }

    public Object invoke(Object object, Method method, Object[] params) throws Throwable {
        ResolvedInstance instance = provider.provide(impl, params);
        return instance.getRef();
    }
}
