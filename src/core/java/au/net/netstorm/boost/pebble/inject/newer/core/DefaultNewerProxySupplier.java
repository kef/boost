package au.net.netstorm.boost.pebble.inject.newer.core;

import java.lang.reflect.InvocationHandler;
import au.net.netstorm.boost.pebble.instantiate.Instantiator;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultNewerProxySupplier implements NewerProxySupplier {
    private ProxyFactory proxyFactory;
    private Instantiator instantiator;
    private ObjectProvider objectProvider;

    public DefaultNewerProxySupplier(ProxyFactory proxyFactory, ObjectProvider objectProvider,
            Instantiator instantiator) {
        this.objectProvider = objectProvider;
        this.proxyFactory = proxyFactory;
        this.instantiator = instantiator;
    }

    public Object nu(Interface newerInterface, Class instanceImplementation) {
        InvocationHandler handler = newHandler(instanceImplementation);
        return proxyFactory.newProxy(newerInterface, handler);
    }

    private InvocationHandler newHandler(Class instanceImplementation) {
        Object[] parameters = {objectProvider, instanceImplementation};
        return (InvocationHandler) instantiator.instantiate(NewerInvocationHandler.class, parameters);
    }
}
