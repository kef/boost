package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public interface PlainProviderEngine {
    ResolvedInstance provide(Implementation impl, Object[] params);
}
