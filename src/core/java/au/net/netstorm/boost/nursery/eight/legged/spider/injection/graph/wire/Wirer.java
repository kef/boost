package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.wire;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.nodes.Node;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.provide.Providers;

public interface Wirer {
    void wire(Node graph, Instances instances, Providers providers);
}
