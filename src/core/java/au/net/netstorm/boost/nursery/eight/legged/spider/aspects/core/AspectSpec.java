package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core;

import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.spider.onion.core.Layer;

public interface AspectSpec {
    Interface[] interfaces();
    Class<? extends Layer>[] layers();
    boolean hasLayers();
}
