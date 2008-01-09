package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.instantiate.Nu;
import static au.net.netstorm.boost.spider.registry.Stamp.MULTIPLE;
import static au.net.netstorm.boost.spider.registry.Stamp.SINGLE;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultRegistry implements Registry {
    private static final Class NO_HOST = Object.class;
    private static final Object[] NO_PARAMS = {};
    private final Blueprints blueprints;
    private final Instances instances;
    private final Factories factories;
    private final Nu nu;

    // SUGGEST: Split registry into two, where Factory stuff has its own interface.
    public DefaultRegistry(Blueprints blueprints, Instances instances, Factories factories, Nu nu) {
        this.blueprints = blueprints;
        this.instances = instances;
        this.factories = factories;
        this.nu = nu;
    }

    public <T, U extends T> void multiple(Class<T> iface, Class<U> impl) {
        blueprint(NO_HOST, iface, impl, MULTIPLE);
    }

    public <T, U extends T> void single(Class<T> iface, Class<U> impl) {
        blueprint(NO_HOST, iface, impl, SINGLE);
    }

    public <T, U extends T> void single(Class<?> host, Class<T> iface, Class<U> impl) {
        blueprint(host, iface, impl, SINGLE);
    }

    public <T, U extends T> void single(Class<?> host, Class<T> iface, String name, Class<U> impl) {
        // FIX ()   2237 Complete.
    }

    public <T, U extends T> void instance(Class<T> iface, U ref) {
        // FIX ()   2237 Tidy?
        Class cls = ref.getClass();
        blueprint(NO_HOST, iface, cls, SINGLE);
        Implementation impl = new DefaultImplementation(cls);
        ResolvedInstance instance = new DefaultBaseReference(ref);
        // FIX ()   2237 Triangulator.
        if (!instances.exists(impl)) instances.put(impl, instance);
    }

    public void factory(Factory factory) {
        factories.add(factory);
    }

    public <T extends Factory> void factory(Class<T> cls) {
        Factory factory = nu.nu(cls);
        factories.add(factory);
    }

    private void blueprint(Class host, Class iface, Class impl, Stamp stamp) {
        Interface sIface = iface(iface);
        Implementation sImpl = new DefaultImplementation(impl);
        Implementation sHost = new DefaultImplementation(host);
        Blueprint blueprint = new DefaultBlueprint(stamp, sImpl, NO_PARAMS);
        blueprints.put(sHost, sIface, blueprint);
    }

    private Interface iface(Class iface) {
        return new DefaultInterface(iface);
    }
}
