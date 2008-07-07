package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

// FIX 2394 use or lose. walk all injection sites and dump result in GraphState future.
public interface SiteWalker {
    void traverse(GraphState state, InjectionSite site);
}
