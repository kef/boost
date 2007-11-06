package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public interface ProviderEngine {
    ResolvedInstance provide(Interface iface, Implementation implementation);

    ResolvedInstance provide(Interface iface, Implementation implementation, Object[] params);
}
