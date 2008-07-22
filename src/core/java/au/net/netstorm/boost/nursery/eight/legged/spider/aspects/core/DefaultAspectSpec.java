package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.spider.onion.core.Layer;

public final class DefaultAspectSpec extends Primordial implements AspectSpec {
    private final Interface[] ifaces;
    private final Class<? extends Layer>[] layers;

    public DefaultAspectSpec(Interface[] ifaces, Class<? extends Layer>[] layers) {
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
