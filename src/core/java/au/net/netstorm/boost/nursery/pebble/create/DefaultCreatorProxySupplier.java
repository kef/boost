package au.net.netstorm.boost.nursery.pebble.create;

import java.lang.reflect.InvocationHandler;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultCreatorProxySupplier implements CreatorProxySupplier {
    private InvocationHandler invocationHandler;
    private ProxyFactory proxyFactory;

    public DefaultCreatorProxySupplier(ProxyFactory proxyFactory, InvocationHandler invocationHandler) {
        this.invocationHandler = invocationHandler;
        this.proxyFactory = proxyFactory;
    }

    public Object create(Interface type) {
        return proxyFactory.newProxy(type, invocationHandler);
    }
}
