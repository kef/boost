package au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public interface Factories {
    Factory find(InjectionSite site);
    void add(Factory factory);
}
