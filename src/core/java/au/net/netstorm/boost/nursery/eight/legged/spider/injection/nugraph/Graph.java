package au.net.netstorm.boost.nursery.eight.legged.spider.injection.nugraph;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.provider.Provider;

// FIX BREADCRUMB 2394 aaaaaaa add wrapper for lifecycle of this guy.
// FIX 2394 use or lose. stores state of graph construction/traversal.
public interface Graph {
    // FIX 2394 split into a mutable graph iface.
    Provider provide(InjectionSite site);

    // FIX 2394 wrap in GraphLifecycle which calls all the right methods in order.c v6m
    void instantiate();

    void resolvable(InjectionSite host, InjectionSite[] sites);

    void wire();

    void post();

    Object resolve(InjectionSite site);

    void add(InjectionSite site, Provider provider);
}
