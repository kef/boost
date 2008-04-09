package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.gunge.type.ResolvedInstance;
import au.net.netstorm.boost.spider.linkage.Linkage;

public interface ResolverEngine {
    ResolvedInstance resolve(Linkage linkage);
}
