package au.net.netstorm.boost.gunge.proxy;

import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.spider.onion.core.Layer;

public interface ProxyFactory {
    Object newProxy(Interface type, Layer layer);

    Object newProxy(Interface[] types, Layer layer);
}
