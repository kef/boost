package au.net.netstorm.boost.test.random;

import java.lang.reflect.InvocationHandler;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultProxySupplier;
import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.test.specific.SpecificProviderRegistry;
import au.net.netstorm.boost.util.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class InterfaceRandomProvider implements RandomProvider {
    private ProxySupplier delegate = new DefaultProxySupplier();
    private ProxyFactory proxyFactory = new DefaultProxyFactory(delegate);
    private final RandomProvider randomProvider;
    private final SpecificProviderRegistry specificProviders;

    public InterfaceRandomProvider(RandomProvider randomProvider, SpecificProviderRegistry specificProviders) {
        this.randomProvider = randomProvider;
        this.specificProviders = specificProviders;
    }

    public boolean canProvide(Class type) {
        return type.isInterface();
    }

    public Object provide(Class type) {
        Interface iface = new DefaultInterface(type);
        InvocationHandler handler = new DummyInterfaceInvocationHandler(type, randomProvider, specificProviders);
        return proxyFactory.newProxy(iface, handler);
    }
}
