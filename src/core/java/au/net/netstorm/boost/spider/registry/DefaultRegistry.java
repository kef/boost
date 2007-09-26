package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.DefaultTypeMaster;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;
import au.net.netstorm.boost.util.type.TypeMaster;

public final class DefaultRegistry implements Registry {
    private static final Stamp MULTIPLE = Stamp.MULTIPLE;
    private static final Stamp SINGLE = Stamp.SINGLE;
    private final TypeMaster typer = new DefaultTypeMaster();
    private final EdgeClass classer = new DefaultEdgeClass();
    private final Injector injector;
    private final Blueprints blueprints;
    private final Instances instances;
    private final Factories factories;

    public DefaultRegistry(Injector injector, Blueprints blueprints, Instances instances, Factories factories) {
        this.injector = injector;
        this.blueprints = blueprints;
        this.instances = instances;
        this.factories = factories;
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
        checkIsFactory(cls);
        Factory factory = buildFactory(cls);
        factories.add(factory);
    }

    private void checkIsFactory(Class cls) {
        Implementation impl = new DefaultImplementation(cls);
        Interface iface = new DefaultInterface(Factory.class);
        // FIX 2145 Use the DoesNotImplementFactoryException.
        if (!isFactory(impl, iface)) throw new IllegalArgumentException();
    }

    // FIX 2145 Create a factory builder.
    private Factory buildFactory(Class cls) {
        Factory factory = (Factory) classer.newInstance(cls);
        injector.inject(factory);
        return factory;
    }

    private boolean isFactory(Implementation impl, Interface iface) {
        return typer.implementz(impl, iface);
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
