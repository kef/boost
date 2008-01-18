package au.net.netstorm.boost.util.proxy;

import au.net.netstorm.boost.spider.onion.core.Closure;
import au.net.netstorm.boost.util.type.Interface;

public interface ProxyFactory {
    Object newProxy(Interface type, Closure closure);

    Object newProxy(Interface[] types, Closure closure);
}
