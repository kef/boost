package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

// FIX 2394 use or lose. stores state of graph construction/traversal.
public interface Graph {
    // FIX 2394 split into a mutable graph iface.
    Provider provide(InjectionSite site);

    // FIX 2394 wrap in GraphLifecycle which calls all the right methods in order.
    void instantiate();
    
    // FIX BREADCRUMB 2394 bbbbbbbbbbbbbb add lifecycle methods for graph: resolve, postprocess
}
