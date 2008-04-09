package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.ResolvedInstance;

public interface ProviderEngine {
    ResolvedInstance provide(Implementation implementation, Object[] params);
}
