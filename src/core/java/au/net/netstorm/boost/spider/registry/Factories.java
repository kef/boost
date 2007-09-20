package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public interface Factories {
    ResolvedInstance get(Interface iface, ImplementationRef host, ProviderEngine provider, Instances instances);

    void add(Factory factory);
}
