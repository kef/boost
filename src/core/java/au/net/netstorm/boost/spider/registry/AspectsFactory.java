package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.util.type.ResolvedInstance;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.spider.core.ProviderEngine;

public class AspectsFactory implements Factory {
    public ResolvedInstance get(Interface iface, Implementation host, ProviderEngine provider) {
        throw new UnsupportedOperationException();
    }

    public boolean canHandle(Interface iface) {
        return false;
    }

    public boolean isSingle(Interface iface) {
        return false;
    }
}
