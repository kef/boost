package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public interface Factory {
    ResolvedInstance get(Interface iface, ImplementationRef host, ProviderEngine provider, Instances instances);

    boolean canHandle(Interface iface);
}
