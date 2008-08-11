package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.postprocess;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.instantiate.Instances;
import au.net.netstorm.boost.spider.resolve.Resolver;

public interface PostProcessor {
    void process(Resolver resolver, Instances instances);
}
