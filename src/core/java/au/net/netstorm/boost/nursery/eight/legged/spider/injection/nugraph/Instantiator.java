package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public interface Instantiator {
    void instantiate(Providers providers, Instances instances, InjectionSite site);

    void instantiate(Providers providers, Instances instances, Iterable<InjectionSite> sites);

    void instantiate(Providers providers, Instances instances, InjectionSite[] sites);
}
