package au.net.netstorm.boost.gunge.proxy;

import au.net.netstorm.boost.spider.onion.core.Layer;

public interface LayerFactoryGloss {
    Object newProxy(Class cls, Layer layer);

    Object newProxy(Class[] classes, Layer layer);
}
