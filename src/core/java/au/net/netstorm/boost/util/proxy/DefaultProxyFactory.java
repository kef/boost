package au.net.netstorm.boost.util.proxy;

import au.net.netstorm.boost.edge.java.lang.reflect.EdgeProxy;
import au.net.netstorm.boost.util.type.Interface;

import java.lang.reflect.InvocationHandler;

public final class DefaultProxyFactory implements ProxyFactory {
    private final EdgeProxy delegate;

    public DefaultProxyFactory(EdgeProxy delegate) {
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
