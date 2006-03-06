package au.net.netstorm.boost.util.proxy;

import java.lang.reflect.InvocationHandler;

import au.net.netstorm.boost.reflect.EdgeProxyFactory;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultProxyFactory implements ProxyFactory {
    public DefaultProxyFactory(EdgeProxyFactory delegate) {
    }

    public Object newProxy(Interface type, InvocationHandler handler) {
        return null; // FIXME: RDSC124
    }
}
