package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

// FIX BREADCRUMB 2394 bbbbbbbbb implementing wrapper for graph
public interface Grapher {
    // FIX BREADCRUMB 2394 ccccccccccc implementing GraphWrapper
    // FIX 2394 pull up.
    Object graph(InjectionSite site);// FIX 2394 pull up.

    Object graph(InjectionSite site, Provider provider);
}
