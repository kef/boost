package au.net.netstorm.boost.gunge.proxy;

import au.net.netstorm.boost.gunge.type.DefaultInterfaceMaster;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.gunge.type.InterfaceMaster;
import au.net.netstorm.boost.spider.onion.core.Layer;

public final class DefaultLayerFactory implements LayerFactory {
    private final LayerFactoryEngine engine = new DefaultLayerFactoryEngine();
    private final InterfaceMaster interfaces = new DefaultInterfaceMaster();

    public Object newProxy(Interface type, Layer layer) {
        return engine.newProxy(type, layer);
    }

    public Object newProxy(Interface[] types, Layer layer) {
        return engine.newProxy(types, layer);
    }

    public Object newProxy(Class cls, Layer layer) {
        Interface[] iface = interfaces.interfaces(cls);
        return newProxy(iface, layer);
    }

    public Object newProxy(Class[] classes, Layer layer) {
        Interface[] ifaces = interfaces.interfaces(classes);
        return newProxy(ifaces, layer);
    }
}
