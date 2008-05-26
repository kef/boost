package au.net.netstorm.boost.nursery.eight.legged.spider.provider.types;

import au.net.netstorm.boost.sledge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.sledge.java.lang.reflect.DefaultProxySupplier;

// FIX 2394 this fellow is a bit questionable - can you write a generic proxy provider
// FIX 2394 or are you better off having simpler providers for each scenario, edge, proxy instance, aspect
public final class ProxyProvider implements Provider {
    private final ProxySupplier supplier = new DefaultProxySupplier();

    public Object nu(Object... args) {
        throw new UnsupportedOperationException();
    }
}
