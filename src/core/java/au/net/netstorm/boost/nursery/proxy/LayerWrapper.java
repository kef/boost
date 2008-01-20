package au.net.netstorm.boost.nursery.proxy;

import au.net.netstorm.boost.spider.onion.core.Layer;

public interface LayerWrapper {
    <T> T wrap(T ref, Layer layer);
}
