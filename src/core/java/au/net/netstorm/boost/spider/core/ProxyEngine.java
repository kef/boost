package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.spider.onion.core.Layer;

public interface ProxyEngine {
    Object proxy(Object ref, Class<? extends Layer>... layers);
}
