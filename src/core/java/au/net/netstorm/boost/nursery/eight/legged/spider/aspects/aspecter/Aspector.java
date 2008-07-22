package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.aspecter;

import au.net.netstorm.boost.spider.onion.core.Layer;

public interface Aspector {
    void cut(Class iface, Class<? extends Layer> aspect);
}
