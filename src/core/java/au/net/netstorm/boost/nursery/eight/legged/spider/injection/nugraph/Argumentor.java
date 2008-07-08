package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public interface Argumentor {
    void register(Providers providers, Instances instances, InjectionSite site, Object[] args);
}
