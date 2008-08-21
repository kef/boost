package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.wire;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.resolve.Resolvables;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.Providers;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.nodes.Node;

public interface Wirer {
    void wire(Node graph, Instances instances, Resolvables resolvables, Providers providers);
}
