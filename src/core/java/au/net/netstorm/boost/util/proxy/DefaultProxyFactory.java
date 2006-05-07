package au.net.netstorm.boost.util.proxy;

import java.lang.reflect.InvocationHandler;

import au.net.netstorm.boost.lang.reflect.EdgeProxyFactory;
import au.net.netstorm.boost.util.type.Interface;

// FIXME: SC521 test build email messages from cruise.

public final class DefaultProxyFactory implements ProxyFactory {
    private final EdgeProxyFactory delegate;

    public DefaultProxyFactory(EdgeProxyFactory delegate) {
        this.delegate = delegate;
    }

    public Object newProxy(Interface type, InvocationHandler handler) {
        ClassLoader classloader = getClassLoader();
        Class cls = type.getType();
        Class[] types = {cls};
        return delegate.getProxy(classloader, types, handler);
    }

    private ClassLoader getClassLoader() {
        Class cls = getClass();
        return cls.getClassLoader();
    }
}
