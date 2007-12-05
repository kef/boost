package au.net.netstorm.boost.spider.assembly;

import au.net.netstorm.boost.edge.java.lang.reflect.DefaultProxySupplier;
import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.util.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.util.proxy.ProxyFactory;

// FIX (Dec 5, 2007) 2233 Move out of spider.
public final class DefaultProxyFactoryAssembler implements ProxyFactoryAssembler {
    public ProxyFactory assemble() {
        ProxySupplier proxySupplier = new DefaultProxySupplier();
        return new DefaultProxyFactory(proxySupplier);
    }
}
