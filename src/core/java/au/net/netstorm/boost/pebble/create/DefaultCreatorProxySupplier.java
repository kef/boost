package au.net.netstorm.boost.pebble.create;

import java.lang.reflect.InvocationHandler;
import au.net.netstorm.boost.pebble.instantiate.Instantiator;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultCreatorProxySupplier implements CreatorProxySupplier {
    private ProxyFactory proxyFactory;
    private Instantiator instantiator;
    private ObjectProvider objectProvider;

    public DefaultCreatorProxySupplier(ProxyFactory proxyFactory, ObjectProvider objectProvider,
            Instantiator instantiator) {
        this.objectProvider = objectProvider;
        this.proxyFactory = proxyFactory;
        this.instantiator = instantiator;
    }

    public Object create(Interface creatorInterface, Class instanceImplementation) {
        InvocationHandler handler = createHandler(instanceImplementation);
        return proxyFactory.newProxy(creatorInterface, handler);
    }

    private InvocationHandler createHandler(Class instanceImplementation) {
        Object[] parameters = {objectProvider, instanceImplementation};
        return (InvocationHandler) instantiator.instantiate(CreatorInvocationHandler.class, parameters);
    }
}
