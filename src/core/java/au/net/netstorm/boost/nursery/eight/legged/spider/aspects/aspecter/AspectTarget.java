package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.aspecter;

import au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core.Aspect;

// FIX 2394 use or lose. building up aspecting code.
public interface AspectTarget {
    void to(Class<? extends Aspect> aspect);
    void to(Aspect aspect);
}
