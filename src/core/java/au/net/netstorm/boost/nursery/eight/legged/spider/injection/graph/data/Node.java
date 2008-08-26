package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.data;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

// FIX 2394 incorporate ctor dependencies.
public interface Node {
    void add(Node child);

    InjectionSite site();

    boolean available();

    Node take();
}
