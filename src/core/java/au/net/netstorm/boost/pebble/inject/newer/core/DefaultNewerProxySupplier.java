package au.net.netstorm.boost.pebble.inject.newer.core;

import java.lang.reflect.InvocationHandler;
import au.net.netstorm.boost.pebble.core.ProviderEngine;
import au.net.netstorm.boost.pebble.instantiate.Instantiator;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.UnresolvedInstance;

public final class DefaultNewerProxySupplier implements NewerProxySupplier {
    private static final Implementation HANDLER = new DefaultImplementation(NewerInvocationHandler.class);
    private ProxyFactory proxyFactory;
    private Instantiator instantiator;
    private ProviderEngine provider;

    public DefaultNewerProxySupplier(ProxyFactory factory, ProviderEngine provider, Instantiator instantiator) {
        this.provider = provider;
        this.proxyFactory = factory;
        this.instantiator = instantiator;
    }

    public Object nu(Interface newerInterface, Implementation instanceImplementation) {
        InvocationHandler handler = newHandler(instanceImplementation);
        return proxyFactory.newProxy(newerInterface, handler);
    }

    private InvocationHandler newHandler(Implementation instanceImplementation) {
        Object[] parameters = {provider, instanceImplementation};
        UnresolvedInstance instantiated = instantiator.instantiate(HANDLER, parameters);
        return (InvocationHandler) instantiated.getRef();
    }
}
