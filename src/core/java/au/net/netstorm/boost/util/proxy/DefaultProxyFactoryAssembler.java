package au.net.netstorm.boost.util.proxy;

import au.net.netstorm.boost.edge.java.lang.reflect.DefaultProxySupplier;
import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;

public final class DefaultProxyFactoryAssembler implements ProxyFactoryAssembler {
    public ProxyFactory assemble() {
        ProxySupplier proxySupplier = new DefaultProxySupplier();
        return new DefaultProxyFactory(proxySupplier);
    }
}
