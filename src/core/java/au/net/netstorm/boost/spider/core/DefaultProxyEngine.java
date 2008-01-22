package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.spider.onion.core.Layer;
import au.net.netstorm.boost.util.proxy.DefaultProxyFactory;
import au.net.netstorm.boost.util.proxy.ProxyFactory;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultProxyEngine implements ProxyEngine {
    private final ProxyFactory factory = new DefaultProxyFactory();
    private final ProxyProviderEngine engine;

    public DefaultProxyEngine(ProxyProviderEngine engine) {
        this.engine = engine;
    }

    public Object proxy(Object ref, Class<? extends Layer>... layers) {
        Object closed = ref;
        for (int i = layers.length - 1; i >= 0; i--) {
            closed = wrap(closed, layers[i]);
        }
        return closed;
    }

    private Object wrap(Object ref, Class<? extends Layer> cls) {
        Interface[] types = ifaces(ref);
        Layer layer = nu(cls, ref);
        return factory.newProxy(types, layer);
    }

    // FIX ()  94156 This sucks here.
    public <T> T nu(Class<T> impl, Object... params) {
        Implementation implementation = new DefaultImplementation(impl);
        ResolvedInstance instance = engine.provide(implementation, params);
        Object ref = instance.getRef();
        return impl.cast(ref);
    }

    // FIX ()  94156 Dupe with TypeMaster?
    private Interface[] ifaces(Object ref) {
        Class cls = ref.getClass();
        Class[] ifaces = cls.getInterfaces();
        Interface[] result = new Interface[ifaces.length];
        for (int i = 0; i < ifaces.length; i++) {
            result[i] = new DefaultInterface(ifaces[i]);
        }
        return result;
    }
}
