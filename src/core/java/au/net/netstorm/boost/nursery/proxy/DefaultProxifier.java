package au.net.netstorm.boost.nursery.proxy;

import au.net.netstorm.boost.nursery.type.core.Types;
import au.net.netstorm.boost.spider.instantiate.Nu;
import au.net.netstorm.boost.spider.onion.core.Layer;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.TypeMaster;

public final class DefaultProxifier implements Proxifier {
    TypeMaster typeMaster;
    ProxyFactory proxies;
    Types types;
    Nu nu;

    public <T> T proxy(T ref, ProxySpec spec) {
        Class<? extends Layer>[] layers = spec.get();
        return (T) enclose(ref, layers);
    }

    public <T> T proxy(T ref, Class<? extends Layer>... layers) {
        return (T) enclose(ref, layers);
    }

    private Object enclose(Object ref, Class<? extends Layer>... layers) {
        Object closed = ref;
        for (int i = layers.length - 1; i >= 0; i--) {
            closed = proxy(closed, layers[i]);
        }
        return closed;
    }

    private Object proxy(Object ref, Class<? extends Layer> cls) {
        Interface[] types = ifaces(ref);
        Layer layer = nu.nu(cls, ref);
        return proxies.newProxy(types, layer);
    }

    // FIX ()  2248 Dupe.  Slam into TypeMaster.
    private Interface[] ifaces(Object ref) {
        Class cls = ref.getClass();
        Implementation impl = types.nu(Implementation.class, cls);
        return typeMaster.declaredInterfaces(impl);
    }
}
