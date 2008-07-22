package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.Providers;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public interface Instantiator {
    void instantiate(Providers providers, Instances instances);

    void instantiate(Providers providers, Instances instances, InjectionSite[] sites);
}