package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

// FIX 2394 use or lose. walk all injection sites and dump result in GraphState future.
public interface SiteWalker {
    void traverse(InjectionSite site);
    
    void traverse(SiteState state, InjectionSite site);

    void traverse(SiteState state, InjectionSite host, InjectionSite[] sites);
}
