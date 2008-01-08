package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public interface Factory {
    // FIX 93259 Remove (obsolete).
    ResolvedInstance get(Interface iface, Implementation host, ProviderEngine provider);

    Blueprint get(Interface iface, Implementation host);

    boolean canHandle(Interface iface);

    boolean isSingle(Interface iface);
}
