package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.nursery.spider.linkage.Linkage;

public interface Factories {
    Factory find(Linkage linkage);

    void add(Factory factory);
}
