package au.net.netstorm.boost.nursery.proxy;

import au.net.netstorm.boost.spider.onion.core.Layer;

public interface LayerSpec {
    Class<? extends Layer>[] get();
}
