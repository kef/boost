package au.net.netstorm.boost.nursery.proxy;

import au.net.netstorm.boost.bullet.primmm.Primordial;
import au.net.netstorm.boost.spider.onion.core.Layer;

public final class DefaultLayerSpec extends Primordial implements LayerSpec {
    private Class<? extends Layer>[] layers;

    public DefaultLayerSpec(Class<? extends Layer>... layers) {
        validate(layers);
        this.layers = layers.clone();
    }

    public Class<? extends Layer>[] getLayers() {
        return layers.clone();
    }

    private void validate(Class[] layers) {
        if (layers == null) throw new IllegalArgumentException();
    }
}
