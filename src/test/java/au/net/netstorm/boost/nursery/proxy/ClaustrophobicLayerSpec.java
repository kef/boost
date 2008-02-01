package au.net.netstorm.boost.nursery.proxy;

import au.net.netstorm.boost.spider.onion.core.Layer;

final class ClaustrophobicLayerSpec implements LayerSpec {
    public Class<? extends Layer>[] getLayers() {
        return new Class[]{CupboardLayer.class};
    }
}
