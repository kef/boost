package au.net.netstorm.boost.gunge.proxy;

import java.lang.reflect.InvocationHandler;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.sledge.java.lang.reflect.DefaultProxySupplier;
import au.net.netstorm.boost.sledge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.spider.onion.core.Layer;

public final class DefaultProxyFactory implements ProxyFactory {
    private final ProxySupplier delegate = new DefaultProxySupplier();

    public Object newProxy(Interface type, Layer layer) {
        Interface[] types = {type};
        return newProxy(types, layer);
    }

    // FIX 9999 THIS IS SEPARATE UTILITY CODE.  UNFORTUNATELY IT HAS BEEN COALESCED.  SPIN OUT!!!!
    // FIX 9999 THEN AGAIN, MAYBE ALL THE PLACES USING INVOCATION HANDLER SHOULD USE THIS!!!
    public Object newProxy(Interface[] types, Layer layer) {
        ClassLoader classloader = getClassLoader();
        Class[] ifaces = toClasses(types);
        InvocationHandler handler = new LayerInvocationHandler(layer);
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
