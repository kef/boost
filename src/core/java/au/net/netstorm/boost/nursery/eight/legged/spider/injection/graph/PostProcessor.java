package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.resolver.AspectResolver;

// FIX 2394 Use or lose.
public interface PostProcessor {
    void process(AspectResolver aspector, Instances instances);
}
