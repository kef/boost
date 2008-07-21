package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core;

// FIX 2394 use or lose. wire in to be injected into aspect constructor.
public interface Cut {
    Aspect[] links();
    Object core();
}
