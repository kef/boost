package au.net.netstorm.boost.nursery.pebble.create;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.DefaultInterface;

public final class DefaultCreatorInjector implements CreatorInjector {
    private InvocationHandler invocationHandler;
    private ProxyFactory proxyFactory;

    public DefaultCreatorInjector(InvocationHandler creatorProxyCreator, ProxyFactory proxyFactory) {
        this.invocationHandler = creatorProxyCreator;
        this.proxyFactory = proxyFactory;
    }

    public void inject(Object objectToInject) {
        proxyFactory.newProxy(new DefaultInterface(Serializable.class), invocationHandler);
    }
}
