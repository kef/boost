package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.ResolvedInstance;

// FIX 2328 replace me - poor abstraction - needs to avoid touching the implementation
public interface ProviderEngine {
    ResolvedInstance provide(Implementation implementation, Object[] params);
}
