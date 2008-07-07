package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

// FIX 2394 use or lose. phase 2 of new Injections.
public interface ResolutionBuilder {
    void build(Injections injections, InjectionSite site);
}
