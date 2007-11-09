package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class SpiderMan implements Factory {
    public boolean canHandle(Interface iface) {
        throw new UnsupportedOperationException();
    }

    public ResolvedInstance get(Interface iface, Implementation host, ProviderEngine provider) {
        throw new UnsupportedOperationException();
    }

    public boolean isSingle(Interface iface) {
        throw new UnsupportedOperationException();
    }
}
