package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.Providers;

public interface Instantiator {
    void instantiate(Providers providers, Instances instances);

    void instantiate(Providers providers, Instances instances, InjectionSite[] sites);

    void instantiate(Providers providers, Instances instances, InjectionSite root, Object[] args);
}
