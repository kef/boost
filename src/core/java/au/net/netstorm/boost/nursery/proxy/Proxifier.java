package au.net.netstorm.boost.nursery.proxy;

import au.net.netstorm.boost.spider.onion.core.Layer;

public interface Proxifier {
    <T> T proxy(T ref, ProxySpec spec);

    <T> T proxy(T ref, Class<? extends Layer>... layers);

    <T> T proxy(T ref, Layer... layers);
}
