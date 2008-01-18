package au.net.netstorm.boost.nursery.proxy;

import au.net.netstorm.boost.spider.onion.core.Layer;

public final class DefaultProxySpec implements ProxySpec {
    private Class<Layer>[] layers;

    public DefaultProxySpec(Class<Layer>... layers) {
        this.layers = layers;
    }

    public Class<Layer>[] get() {
        return layers;
    }
}
