package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class SoapFactory implements Factory {

    public ResolvedInstance get(Interface iface, Implementation host, ProviderEngine provider, Instances instances) {
        throw new UnsupportedOperationException();
    }

    public boolean canHandle(Interface iface) {
        throw new UnsupportedOperationException();
    }
}