package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public interface Instantiator {
    void instantiate(Providers providers, Instances instances);

    void instantiate(Providers providers, Instances instances, InjectionSite[] sites);

    void instantiate(Providers providers, Instances instances, InjectionSite root, Object[] args);
}
