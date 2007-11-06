package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public interface Factory {
    StampedResolvedInstance get(Interface iface, Implementation host, ProviderEngine provider);

    boolean canHandle(Interface iface);
}
