package au.net.netstorm.boost.spider.register;

import au.net.netstorm.boost.spider.linkage.Linkage;

public interface Factories {
    Factory find(Linkage linkage);

    void add(Factory factory);
}
