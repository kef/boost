package au.net.netstorm.boost.util.proxy;

import au.net.netstorm.boost.spider.onion.core.Layer;
import au.net.netstorm.boost.util.type.Interface;

public interface ProxyFactory {
    Object newProxy(Interface type, Layer layer);

    Object newProxy(Interface[] types, Layer layer);
}
