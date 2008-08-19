package au.net.netstorm.boost.gunge.proxy;

import java.lang.reflect.InvocationHandler;
import au.net.netstorm.boost.gunge.array.ArrayMaster;
import au.net.netstorm.boost.gunge.array.DefaultArrayMaster;
import au.net.netstorm.boost.gunge.type.DefaultInterface;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.sledge.java.lang.reflect.DefaultProxySupplier;
import au.net.netstorm.boost.sledge.java.lang.reflect.ProxySupplier;
import au.net.netstorm.boost.spider.onion.core.Layer;
import au.net.netstorm.boost.spider.onion.core.Layered;

public final class DefaultLayerProxyFactory implements LayerProxyFactory {
    private static final Interface LAYERED = new DefaultInterface(Layered.class);
    private final ProxySupplier delegate = new DefaultProxySupplier();
    private final ArrayMaster arrays = new DefaultArrayMaster();

    // FIX 2130 Split layering logic and pure ProxyFactory.
    public Object newProxy(Interface type, Layer layer) {
        Interface[] types = {type};
        return newProxy(types, layer);
    }

    // FIX 2130 THIS IS SEPARATE UTILITY CODE.  UNFORTUNATELY IT HAS BEEN COALESCED.  SPIN OUT!!!!
    // FIX 2130 THEN AGAIN, MAYBE ALL THE PLACES USING INVOCATION HANDLER SHOULD USE THIS!!!
    public Object newProxy(Interface[] ifaces, Layer layer) {
        ClassLoader classloader = getClassLoader();
        Interface[] all = wrap(ifaces);
        Class[] types = classes(all);
        InvocationHandler handler = new LayerInvocationHandler(layer);
        return delegate.getProxy(classloader, types, handler);
    }

    private Interface[] wrap(Interface[] ifaces) {
        Interface[] access = {LAYERED};
        return arrays.plus(ifaces, access);
    }

    // FIX 2130 Pure ProxyFactory.
    private Class[] classes(Interface[] types) {
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
