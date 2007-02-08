package au.net.netstorm.boost.nursery.pebble.create;

import java.lang.reflect.InvocationHandler;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultOldCreatorProxySupplier implements OldCreatorProxySupplier {
    private InvocationHandler invocationHandler;
    private ProxyFactory proxyFactory;

    public DefaultOldCreatorProxySupplier(ProxyFactory proxyFactory, InvocationHandler invocationHandler) {
        this.invocationHandler = invocationHandler;
        this.proxyFactory = proxyFactory;
    }

    public Object create(Interface type) {
        return proxyFactory.newProxy(type, invocationHandler);
    }

/*
    private ProxyFactory proxyFactory;
    private GenericCreator genericCreator;

    public DefaultCreatorProxySupplier(ProxyFactory proxyFactory, GenericCreator genericCreator) {
        this.proxyFactory = proxyFactory;
        this.genericCreator = genericCreator;
    }

    public Object create(Class instanceImplementation, Interface creatorInterface) {
        InvocationHandler invocationHandler = new CreatorInvocationHandler(genericCreator, instanceImplementation);
        return proxyFactory.newProxy(creatorInterface, invocationHandler);
    }
*/
}
