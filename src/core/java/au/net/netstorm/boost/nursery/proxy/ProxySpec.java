package au.net.netstorm.boost.nursery.proxy;

import au.net.netstorm.boost.spider.onion.core.Layer;

public interface ProxySpec {
    Class<? extends Layer>[] get();
}
