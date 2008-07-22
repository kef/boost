package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core;

import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.spider.onion.core.Layer;

// FIX 2394 Use or lose. Represent an aspect type.
public interface AspectType {
    Interface[] interfaces();
    Class<? extends Layer>[] layers();
    boolean hasLayers();
}
