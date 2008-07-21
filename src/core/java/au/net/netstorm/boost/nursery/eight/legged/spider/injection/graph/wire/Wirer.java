package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.wire;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instances;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.resolve.Resolvables;

public interface Wirer {
    void wire(Instances instances, Resolvables resolvables);
}
