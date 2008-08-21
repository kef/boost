package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.nodes.Node;

public interface LifecycleInstance {
    void build();

    void instantiate();

    void wire();

    void post();

    Object resolve();
}
