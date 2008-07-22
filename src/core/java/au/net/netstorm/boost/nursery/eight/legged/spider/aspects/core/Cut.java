package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core;

import java.util.List;

import au.net.netstorm.boost.spider.onion.core.Layer;

// FIX 2394 name. move to Onion terminology.
public interface Cut {
    // FIX 2394 split into mutable and immutable ifaces.
    void add(Layer aspect);
    Layer outer();
    List<Layer> links();
    Object core();
}
