package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core;

// FIX 2394 Use or lose. Wire into AspectResolver.
public final class DefaultAspects implements Aspects {
    // FIX 2394 split into read/write
    public void add(Class iface, Aspect aspect) {
        throw new UnsupportedOperationException();
    }
}
