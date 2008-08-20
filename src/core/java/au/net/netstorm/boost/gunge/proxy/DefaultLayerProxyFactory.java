package au.net.netstorm.boost.gunge.proxy;

import java.lang.reflect.InvocationHandler;

import au.net.netstorm.boost.gunge.array.ArrayMaster;
import au.net.netstorm.boost.gunge.array.DefaultArrayMaster;
import au.net.netstorm.boost.gunge.type.DefaultInterface;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.spider.onion.core.Layer;
import au.net.netstorm.boost.spider.onion.core.Layered;

public final class DefaultLayerProxyFactory implements LayerProxyFactory {
    private static final Interface LAYERED = new DefaultInterface(Layered.class);
    private final ArrayMaster arrays = new DefaultArrayMaster();
    private final ProxyFactory proxies = new DefaultProxyFactory();

    public Object newProxy(Interface type, Layer layer) {
        Interface[] types = {type};
        return newProxy(types, layer);
    }

    public Object newProxy(Interface[] ifaces, Layer layer) {
        Interface[] all = arrays.plus(ifaces, LAYERED);
        InvocationHandler handler = new LayerInvocationHandler(layer);
        return proxies.proxy(handler, all);
    }
}
