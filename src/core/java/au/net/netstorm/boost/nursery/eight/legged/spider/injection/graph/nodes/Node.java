package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.nodes;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public interface Node {
    void add(Node child);

    InjectionSite site();

    boolean available();

    Node take();
}
