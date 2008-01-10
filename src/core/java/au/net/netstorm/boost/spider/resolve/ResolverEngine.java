package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.nursery.spider.registry.Linkage;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public interface ResolverEngine {
    ResolvedInstance resolve(Linkage linkage);
}
