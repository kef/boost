package au.net.netstorm.boost.nursery.spider.registry;

import au.net.netstorm.boost.spider.instantiate.Nu;
import au.net.netstorm.boost.spider.linkage.DefaultLinkageFactory;
import au.net.netstorm.boost.spider.linkage.Linkage;
import au.net.netstorm.boost.spider.linkage.LinkageFactory;
import au.net.netstorm.boost.spider.registry.Blueprint;
import au.net.netstorm.boost.spider.registry.Blueprints;
import au.net.netstorm.boost.spider.registry.DefaultBlueprint;
import au.net.netstorm.boost.spider.registry.Factories;
import au.net.netstorm.boost.spider.registry.Factory;
import au.net.netstorm.boost.spider.registry.Instances;
import au.net.netstorm.boost.spider.registry.Registry;
import au.net.netstorm.boost.spider.registry.Stamp;
import static au.net.netstorm.boost.spider.registry.Stamp.MULTIPLE;
import static au.net.netstorm.boost.spider.registry.Stamp.SINGLE;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultRegistry implements Registry {
    private static final Object[] NO_PARAMS = {};
    private final LinkageFactory linkages = new DefaultLinkageFactory();
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
        Linkage linkage = linkages.nu(iface);
        blueprint(linkage, impl, MULTIPLE);
    }

    public <T, U extends T> void single(Class<T> iface, Class<U> impl) {
        Linkage linkage = linkages.nu(iface);
        blueprint(linkage, impl, SINGLE);
    }

    public <T, U extends T> void single(Class<?> host, Class<T> iface, Class<U> impl) {
        Linkage linkage = linkages.nu(host, iface);
        blueprint(linkage, impl, SINGLE);
    }

    public <T, U extends T> void single(Class<?> host, Class<T> iface, String name, Class<U> impl) {
//        Linkage linkage = linkages.nu(host, iface, name);
        // FIX ()   2237 Complete.
    }

    public <T, U extends T> void instance(Class<T> iface, U ref) {
        Class cls = ref.getClass();
        blueprint(iface, cls);
        instance(iface, cls, ref);
    }

    public void factory(Factory factory) {
        factories.add(factory);
    }

    public <T extends Factory> void factory(Class<T> cls) {
        Factory factory = nu.nu(cls);
        factories.add(factory);
    }

    private <T, U extends T> void instance(Class<T> iface, Class<U> cls, U ref) {
        Interface inyerface = new DefaultInterface(iface);
        Implementation impl = new DefaultImplementation(cls);
        ResolvedInstance instance = new DefaultBaseReference(ref);
        // FIX ()   2237 Triangulator.
        instances.put(inyerface, impl, instance);
    }

    private void blueprint(Class iface, Class cls) {
        Linkage linkage = linkages.nu(iface);
        blueprint(linkage, cls, SINGLE);
    }

    private void blueprint(Linkage linkage, Class impl, Stamp stamp) {
        Implementation sImpl = new DefaultImplementation(impl);
        Blueprint blueprint = new DefaultBlueprint(stamp, sImpl, NO_PARAMS);
        blueprints.put(linkage, blueprint);
    }
}
