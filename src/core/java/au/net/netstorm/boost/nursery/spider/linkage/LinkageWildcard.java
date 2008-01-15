package au.net.netstorm.boost.nursery.spider.linkage;

import au.net.netstorm.boost.spider.linkage.Linkage;

public interface LinkageWildcard {
    Linkage name(Linkage linkage);

    Linkage host(Linkage linkage);

    Linkage both(Linkage linkage);
}
