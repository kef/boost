package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.spider.onion.core.Layer;

// FIX 2394 Use or lose. Represent an aspect type.
public final class DefaultAspectType extends Primordial implements AspectType {
    private final Interface[] ifaces;
    private final Class<? extends Layer>[] layers;

    // FIX 2394 implement me.
    public DefaultAspectType(Interface[] ifaces, Class<? extends Layer>[] layers) {
        this.ifaces = ifaces;
        this.layers = layers;
    }

    public Interface[] interfaces() {
        return ifaces;
    }

    public Class<? extends Layer>[] layers() {
        return layers;
    }

    public boolean hasLayers() {
        return layers.length != 0;
    }
}
