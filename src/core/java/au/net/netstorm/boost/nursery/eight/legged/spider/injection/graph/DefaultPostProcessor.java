package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph;

import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.resolver.AspectResolver;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.resolver.DefaultAspectResolver;

// FIX 2394 implement.
public final class DefaultPostProcessor implements PostProcessor {
    private final AspectResolver aspects = new DefaultAspectResolver();

    public void process(Instances instances) {

    }
}
