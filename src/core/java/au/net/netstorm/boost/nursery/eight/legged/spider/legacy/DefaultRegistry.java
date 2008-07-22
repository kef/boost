package au.net.netstorm.boost.nursery.eight.legged.spider.legacy;

import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder.Binder;
import au.net.netstorm.boost.spider.onion.core.Layer;
import au.net.netstorm.boost.spider.registry.Factory;
import au.net.netstorm.boost.spider.registry.Registry;

// FIX 2394 wire in legacy wrapper.
public final class DefaultRegistry implements Registry {
    private final Binder binder;

    public DefaultRegistry(Binder binder) {
        this.binder = binder;
    }

    public <T> void multiple(Class<T> iface, Class<? extends T> impl) {
        binder.bind(iface).to(impl);
    }

    public <T> void single(Class<T> iface, Class<? extends T> impl) {
        binder.bind(iface).toSingle(impl);
    }

    public <T> void single(Class host, Class<T> iface, Class<? extends T> impl) {
        binder.bind(iface, host).toSingle(impl);
    }

    public <T> void single(Class host, Class<T> iface, String name, Class<? extends T> impl) {
        binder.bind(iface, host, name).toSingle(impl);
    }

    public void layer(Class impl, Class<? extends Layer>... layers) {
        throw new UnsupportedOperationException();
    }

    public <T, U extends T> void instance(Class<T> iface, U ref) {
        binder.bind(iface).to(ref);
    }

    public <T, U extends T> void instance(Class<?> host, Class<T> iface, U ref) {
        binder.bind(iface, host).to(ref);
    }

    // FIX 2394 implement wrapper for factories, or is it easier to just convert them all.
    public <T extends Factory> void factory(Class<T> cls) {
        throw new UnsupportedOperationException();
    }

    public void factory(Factory factory) {
        throw new UnsupportedOperationException();
    }
}
