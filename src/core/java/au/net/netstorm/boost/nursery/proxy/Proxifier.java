package au.net.netstorm.boost.nursery.proxy;

import au.net.netstorm.boost.spider.onion.core.Layer;

public interface Proxifier {
    // FIX 2248 Rename?
    <T> T proxy(T ref, ProxySpec spec);

    <T> T proxy(T ref, Class<? extends Layer>... layers);
}
