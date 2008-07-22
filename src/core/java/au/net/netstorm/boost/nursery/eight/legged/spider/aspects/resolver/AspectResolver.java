package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.resolver;

import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.AspectSpec;

// FIX 2394 Use or lose. Wire into PostProcessor.
public interface AspectResolver {
    AspectSpec resolve(Object o);
}
