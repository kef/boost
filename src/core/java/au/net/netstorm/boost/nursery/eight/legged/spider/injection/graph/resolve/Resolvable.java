package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.resolve;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public interface Resolvable {
    InjectionSite host();

    InjectionSite[] sites();
}
