package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core;

import au.net.netstorm.boost.spider.onion.core.Layer;

// FIX 2394 Use or lose. Wire into AspectResolver.
public interface Aspects {
    // FIX 2394 split into read/write
    void add(Class iface, Class<? extends Layer> aspect);

    Class<? extends Layer>[] get(Class iface);
}
