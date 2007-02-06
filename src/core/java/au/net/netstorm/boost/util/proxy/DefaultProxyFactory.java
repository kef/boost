package au.net.netstorm.boost.util.proxy;

import java.lang.reflect.InvocationHandler;
import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.util.type.Interface;

// FIX 1665 Is this really a Factory? Rename.
public final class DefaultProxyFactory implements ProxyFactory {

    private final ProxySupplier delegate;

    public DefaultProxyFactory(ProxySupplier delegate) {
        this.delegate = delegate;
    }

    public Object newProxy(Interface type, InvocationHandler handler) {
        Interface[] types = {type};
        return newProxy(types, handler);
    }

    public Object newProxy(Interface[] types, InvocationHandler handler) {
        ClassLoader classloader = getClassLoader();
        Class[] ifaces = toClasses(types);
        return delegate.getProxy(classloader, ifaces, handler);
    }

    private Class[] toClasses(Interface[] types) {
        int length = types.length;
        Class[] result = new Class[length];
        for (int i = 0; i < length; i++) {
            result[i] = types[i].getType();
        }
        return result;
    }

    private ClassLoader getClassLoader() {
        Class cls = getClass();
        return cls.getClassLoader();
    }
}
