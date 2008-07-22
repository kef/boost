package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public interface SiteWalker {
    void traverse(InjectionSite site);
    
    void traverse(SiteState state, InjectionSite site);

    void traverse(SiteState state, InjectionSite host, InjectionSite[] sites);
}
