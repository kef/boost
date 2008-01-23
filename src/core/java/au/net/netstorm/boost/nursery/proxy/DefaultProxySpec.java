package au.net.netstorm.boost.nursery.proxy;

import au.net.netstorm.boost.spider.onion.core.Layer;

// FIX ()  94156 TD.  Copy in and out.
public final class DefaultProxySpec implements ProxySpec {
    private Class<? extends Layer>[] layers;

    public DefaultProxySpec(Class<? extends Layer>... layers) {
        this.layers = layers;
    }

    public Class<? extends Layer>[] get() {
        return layers;
    }
}
