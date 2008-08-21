package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core;

import au.net.netstorm.boost.spider.onion.core.Layer;

import java.util.List;

// FIX 2394 name. move to Onion terminology.
public interface Cut {
    // FIX 2394 split into mutable and immutable ifaces.
    void add(Layer aspect);

    Layer outer();

    List<Layer> links();

    // FIX 2130 Consider removing this, so outgoing injection sites can be "cut".
    Object core();
}
