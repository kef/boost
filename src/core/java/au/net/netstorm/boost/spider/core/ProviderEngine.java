package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

// SUGGEST: SM and others are not comfortable with iface being passed in.

// FIX NOW THIS IS A NuEngine not a ProviderEngine now DefaultProvider is
public interface ProviderEngine {
    ResolvedInstance provide(Implementation implementation, Object[] params);
}
