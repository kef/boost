package au.net.netstorm.boost.nursery.proxy;

import au.net.netstorm.boost.spider.onion.core.Layer;

// FIX ()  94156 TD.  Copy in and out.
public final class DefaultLayerSpec implements LayerSpec {
    private Class<? extends Layer>[] layers;

    public DefaultLayerSpec(Class<? extends Layer>... layers) {
        this.layers = layers;
    }

    public Class<? extends Layer>[] get() {
        return layers;
    }
}
