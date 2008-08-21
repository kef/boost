package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.nodes;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

// FIX 2394 use or lose. wire into site walker build dependency graph of nodes.
// FIX 2394 this approach is better suited to handling aspects and lifecycles.
public interface Node extends Iterable<Node> {
    void add(Node child);

    InjectionSite site();
}
