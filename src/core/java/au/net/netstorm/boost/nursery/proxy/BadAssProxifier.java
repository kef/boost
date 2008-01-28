package au.net.netstorm.boost.nursery.proxy;

import au.net.netstorm.boost.spider.core.ProviderEngine;
import au.net.netstorm.boost.spider.instantiate.DefaultNu;
import au.net.netstorm.boost.spider.instantiate.Nu;
import au.net.netstorm.boost.spider.onion.core.Layer;
import au.net.netstorm.boost.util.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultTypeMaster;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.TypeMaster;

// FIX ()   94156 Big time dupe with DefaultProxifier!!!!!!!!

// FIX ()   94156 Delete me!!!!!!!!!
public final class BadAssProxifier implements Proxifier {
    private final ProxyFactory proxies = new DefaultProxyFactory();
    private final TypeMaster typer = new DefaultTypeMaster();
    private final Nu nu;

    public BadAssProxifier(ProviderEngine engine) {
        nu = new DefaultNu(engine);
    }

    public <T> T proxy(T ref, LayerSpec spec) {
        Class<? extends Layer>[] layers = spec.getLayers();
        return (T) enclose(ref, layers);
    }

    public <T> T proxy(T ref, Class<? extends Layer>... layers) {
        return (T) enclose(ref, layers);
    }

    public <T> T proxy(T ref, Layer... layers) {
        return (T) enclose(ref, layers);
    }

    private Object enclose(Object ref, Class<? extends Layer>... classes) {
        Object closed = ref;
        for (int i = classes.length - 1; i >= 0; i--) {
            closed = wrap(closed, classes[i]);
        }
        return closed;
    }

    private Object enclose(Object ref, Layer... layers) {
        Object closed = ref;
        for (int i = layers.length - 1; i >= 0; i--) {
            closed = wrap(closed, layers[i]);
        }
        return closed;
    }

    private Object wrap(Object ref, Class<? extends Layer> cls) {
        Layer layer = nu.nu(cls, ref);
        return wrap(ref, layer);
    }

    private Object wrap(Object ref, Layer layer) {
        Interface[] types = ifaces(ref);
        return proxies.newProxy(types, layer);
    }

    // FIX ()  94156 Dupe with TypeMaster?
    private Interface[] ifaces(Object ref) {
        Class cls = ref.getClass();
        Implementation impl = new DefaultImplementation(cls);
        return typer.declaredInterfaces(impl);
    }
}
