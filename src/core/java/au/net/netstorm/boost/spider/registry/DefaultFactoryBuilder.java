package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.DefaultTypeMaster;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.TypeMaster;

public final class DefaultFactoryBuilder implements FactoryBuilder {
    private final TypeMaster typer = new DefaultTypeMaster();
    private final EdgeClass classer = new DefaultEdgeClass();
    private final Injector injector;

    public DefaultFactoryBuilder(Injector injector) {
        this.injector = injector;
    }

    public Factory build(Class cls) {
        checkIsFactory(cls);
        return buildFactory(cls, injector);
    }

    private void checkIsFactory(Class cls) {
        Implementation impl = new DefaultImplementation(cls);
        Interface iface = new DefaultInterface(Factory.class);
        if (!isFactory(impl, iface)) throw new DoesNotImplementFactoryException(cls, iface);
    }

    private Factory buildFactory(Class cls, Injector injector) {
        Factory factory = (Factory) classer.newInstance(cls);
        injector.inject(factory);
        return factory;
    }

    private boolean isFactory(Implementation impl, Interface iface) {
        return typer.implementz(impl, iface);
    }
}
