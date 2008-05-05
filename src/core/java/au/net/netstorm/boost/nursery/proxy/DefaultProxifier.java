package au.net.netstorm.boost.nursery.proxy;

import au.net.netstorm.boost.gunge.proxy.ProxyFactory;
import au.net.netstorm.boost.gunge.type.DefaultImplementation;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.gunge.type.TypeMaster;
import au.net.netstorm.boost.spider.instantiate.Nu;
import au.net.netstorm.boost.spider.onion.core.Layer;

// FIX ()   2248 Getting too big.
public final class DefaultProxifier implements Proxifier {
    TypeMaster typer;
    ProxyFactory proxies;
    Nu nu;

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

    // FIX ()  2248 Dupe.  Slam into TypeMaster.
    private Interface[] ifaces(Object ref) {
        Class cls = ref.getClass();
        Implementation impl = nu.nu(DefaultImplementation.class, cls);
        return typer.declaredInterfaces(impl);
    }
}
