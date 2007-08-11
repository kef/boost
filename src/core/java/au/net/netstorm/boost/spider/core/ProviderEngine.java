package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public interface ProviderEngine {
    ResolvedInstance provide(Implementation implementation);

    ResolvedInstance provide(Implementation implementation, Object[] resolved);
}
