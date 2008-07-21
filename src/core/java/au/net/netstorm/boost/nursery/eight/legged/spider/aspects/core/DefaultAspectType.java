package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core;

// FIX 2394 Use or lose. Represent an aspect type.
public final class DefaultAspectType implements AspectType {
    private final Class[] ifaces;
    private final Aspect core;
    private final Class<? extends Aspect>[] layers;

    // FIX 2394 implement me.
    public DefaultAspectType(Class[] ifaces, Aspect core, Class<? extends Aspect>[] layers) {
        this.ifaces = ifaces;
        this.core = core;
        this.layers = layers;
    }

    public boolean hasLayers() {
        return layers.length != 0;
    }
}
