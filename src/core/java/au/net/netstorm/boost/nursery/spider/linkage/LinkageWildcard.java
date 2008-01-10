package au.net.netstorm.boost.nursery.spider.linkage;

public interface LinkageWildcard {
    Linkage name(Linkage linkage);

    Linkage host(Linkage linkage);

    Linkage both(Linkage linkage);
}
