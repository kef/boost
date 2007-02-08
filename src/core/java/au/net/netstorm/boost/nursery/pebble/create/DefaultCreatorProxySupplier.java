package au.net.netstorm.boost.nursery.pebble.create;

import java.lang.reflect.InvocationHandler;
import au.net.netstorm.boost.nursery.pebble.instantiate.Instantiator;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultCreatorProxySupplier implements CreatorProxySupplier {
    private ProxyFactory proxyFactory;
    private Instantiator instantiator;
    private Creator creator;

    public DefaultCreatorProxySupplier(ProxyFactory proxyFactory, Creator creator, Instantiator instantiator) {
        this.creator = creator;
        this.proxyFactory = proxyFactory;
        this.instantiator = instantiator;
    }

    public Object create(Interface creatorInterface, Class instanceImplementation) {
        InvocationHandler handler = createHandler(instanceImplementation);
        return proxyFactory.newProxy(creatorInterface, handler);
    }

    private InvocationHandler createHandler(Class instanceImplementation) {
        Object[] parameters = {creator, instanceImplementation};
        return (InvocationHandler) instantiator.instantiate(CreatorInvocationHandler.class, parameters);
    }
}
