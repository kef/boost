package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.resolver;

import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.Aspects;
import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.DefaultAspects;

// FIX 2394 Use or lose. Wire into PostProcessor.
public final class DefaultAspectResolver implements AspectResolver {
    private final Aspects aspects = new DefaultAspects();
}
