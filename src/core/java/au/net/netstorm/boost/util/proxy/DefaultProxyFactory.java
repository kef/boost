package au.net.netstorm.boost.util.proxy;

import au.net.netstorm.boost.edge.java.lang.reflect.DefaultProxySupplier;
import au.net.netstorm.boost.edge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.spider.onion.core.Closure;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultProxyFactory implements ProxyFactory {
    private final ProxySupplier delegate = new DefaultProxySupplier();

    public Object newProxy(Interface type, Closure closure) {
        Interface[] types = {type};
        return newProxy(types, closure);
    }

    public Object newProxy(Interface[] types, Closure closure) {
        ClassLoader classloader = getClassLoader();
        Class[] ifaces = toClasses(types);
        return delegate.getProxy(classloader, ifaces, closure);
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
