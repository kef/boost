package au.net.netstorm.boost.util.proxy;

import java.lang.reflect.InvocationHandler;

import au.net.netstorm.boost.reflect.EdgeProxyFactory;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultProxyFactory implements ProxyFactory {
    private final EdgeProxyFactory delegate;

    public DefaultProxyFactory(EdgeProxyFactory delegate) {
        this.delegate = delegate;
    }

    public Object newProxy(Interface type, InvocationHandler handler) {
        Class cls = getClass();
        ClassLoader classloader = cls.getClassLoader();
        delegate.getProxy(classloader, null, null);
        return null; // FIXME: RDSC124
    }
}
