package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultRegistry implements Registry {
    private static final Stamp MULTIPLE = Stamp.MULTIPLE;
    private static final Stamp SINGLE = Stamp.SINGLE;
    private final EdgeClass classer = new DefaultEdgeClass();
    private final Instances instances;
    private final Factories factories;
    private final Injector injector;
    private final Blueprints blueprints;

    public DefaultRegistry(Blueprints blueprints, Instances instances, Factories factories, Injector injector) {
        this.blueprints = blueprints;
        this.instances = instances;
        this.factories = factories;
        this.injector = injector;
    }

    public void multiple(Class iface, Class impl) {
        blueprint(iface, impl, MULTIPLE);
    }

    public void single(Class iface, Class impl) {
        blueprint(iface, impl, SINGLE);
    }

    public void instance(Class iface, Object ref) {
        Interface inyerface = iface(iface);
        ResolvedInstance instance = new DefaultBaseReference(ref);
        instances.put(inyerface, instance);
    }

    public void factory(Factory factory) {
        factories.add(factory);
    }

    public void factory(Class cls) {
        // FIX 74285 Check that the class passed in implements "Factory".
        Factory factory = (Factory) classer.newInstance(cls);
        injector.inject(factory);
        factories.add(factory);
    }

    private void blueprint(Class iface, Class impl, Stamp stamp) {
        Interface inyerface = iface(iface);
        Implementation implementation = new DefaultImplementation(impl);
        Blueprint blueprint = new DefaultBlueprint(stamp, implementation);
        blueprints.put(inyerface, blueprint);
    }

    private Interface iface(Class iface) {
        return new DefaultInterface(iface);
    }
}
