package au.net.netstorm.boost.test.random;

import java.lang.reflect.InvocationHandler;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultProxySupplier;
import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.util.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class InterfaceRandomProvider implements RandomProvider {
    private ProxySupplier delegate = new DefaultProxySupplier();
    private ProxyFactory proxyFactory = new DefaultProxyFactory(delegate);
    private final RandomProvider randomProvider;

    public InterfaceRandomProvider(RandomProvider randomProvider) {
        this.randomProvider = randomProvider;
    }

    public Object get(Class type) {
        Interface iface = new DefaultInterface(type);
        InvocationHandler handler = new RandomInterfaceInvocationHandler(randomProvider);
        return proxyFactory.newProxy(iface, handler);
    }
}
