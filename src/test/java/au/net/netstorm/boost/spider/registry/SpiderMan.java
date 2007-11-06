package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class SpiderMan implements Factory {
    public boolean canHandle(Interface iface) {
        throw new UnsupportedOperationException();
    }

    public StampedResolvedInstance get(Interface iface, Implementation host, ProviderEngine provider) {
        throw new UnsupportedOperationException();
    }
}
