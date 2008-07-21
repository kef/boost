package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core;

// FIX 2394 Use or lose. Wire into AspectResolver.
public interface Aspects {
    // FIX 2394 split into read/write
    void add(Class iface, Aspect aspect);
}
