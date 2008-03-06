package au.net.netstorm.boost.spider.register;

import au.net.netstorm.boost.nursery.proxy.DefaultLayerSpec;
import au.net.netstorm.boost.nursery.proxy.LayerSpec;
import au.net.netstorm.boost.nursery.spider.layer.Layers;
import au.net.netstorm.boost.nursery.util.type.DefaultImplementation;
import au.net.netstorm.boost.nursery.util.type.DefaultInterface;
import au.net.netstorm.boost.spider.instantiate.Nu;
import au.net.netstorm.boost.spider.linkage.DefaultLinkageFactory;
import au.net.netstorm.boost.spider.linkage.Linkage;
import au.net.netstorm.boost.spider.linkage.LinkageFactory;
import au.net.netstorm.boost.spider.onion.core.Layer;
import static au.net.netstorm.boost.spider.register.Stamp.MULTIPLE;
import static au.net.netstorm.boost.spider.register.Stamp.SINGLE;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

// DEBT ParameterNumber {
public final class DefaultRegistry implements Registry {
    private static final Object[] NO_PARAMS = {};
    private final LinkageFactory linkages = new DefaultLinkageFactory();
    private final Blueprints blueprints;
    private final Instances instances;
    private final Factories factories;
    private final Layers proxies;
    private final Nu nu;

    // SUGGEST: Split registry into two, where Factory stuff has its own interface.
    public DefaultRegistry(Blueprints blueprints, Instances instances, Factories factories, Layers proxies, Nu nu) {
        this.blueprints = blueprints;
        this.instances = instances;
        this.factories = factories;
        this.proxies = proxies;
        this.nu = nu;
    }

    public <T> void multiple(Class<T> iface, Class<? extends T> impl) {
        Linkage linkage = linkages.nu(iface);
        blueprint(linkage, impl, MULTIPLE);
    }

    public <T> void single(Class<T> iface, Class<? extends T> impl) {
        blueprint(iface, impl);
    }

    public <T> void single(Class host, Class<T> iface, Class<? extends T> impl) {
        blueprint(host, iface, impl);
    }

    public <T> void single(Class host, Class<T> iface, String name, Class<? extends T> impl) {
        Linkage linkage = linkages.nu(host, iface, name);
        blueprint(linkage, impl, SINGLE);
    }

    public <T, U extends T> void instance(Class<T> iface, U ref) {
        Class cls = ref.getClass();
        blueprint(iface, cls);
        addInstance(iface, cls, ref);
    }

    public <T, U extends T> void instance(Class<?> host, Class<T> iface, U ref) {
        Class cls = ref.getClass();
        blueprint(host, iface, cls);
        addInstance(iface, cls, ref);
    }

    public void factory(Factory factory) {
        factories.add(factory);
    }

    public <T extends Factory> void factory(Class<T> cls) {
        Factory factory = nu.nu(cls);
        factories.add(factory);
    }

    public void layer(Class impl, Class<? extends Layer>... layers) {
        Implementation implementation = impl(impl);
        LayerSpec spec = new DefaultLayerSpec(layers);
        proxies.put(implementation, spec);
    }

    private <T, U extends T> void addInstance(Class<T> iface, Class<U> cls, U ref) {
        Interface inyerface = new DefaultInterface(iface);
        Implementation impl = impl(cls);
        ResolvedInstance instance = new DefaultBaseReference(ref);
        // FIX ()   2237 Triangulator.
        instances.put(inyerface, impl, instance);
    }

    private <T> void blueprint(Class<?> host, Class<T> iface, Class<? extends T> impl) {
        Linkage linkage = linkages.nu(host, iface);
        blueprint(linkage, impl, SINGLE);
    }

    private <T> void blueprint(Class<T> iface, Class<? extends T> impl) {
        Linkage linkage = linkages.nu(iface);
        blueprint(linkage, impl, SINGLE);
    }

    private void blueprint(Linkage linkage, Class impl, Stamp stamp) {
        Implementation sImpl = impl(impl);
        Blueprint blueprint = new DefaultBlueprint(stamp, sImpl, NO_PARAMS);
        blueprints.put(linkage, blueprint);
    }

    private Implementation impl(Class cls) {
        return new DefaultImplementation(cls);
    }
}
// } DEBT ParameterNumber