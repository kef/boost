package au.net.netstorm.boost.demo.spider.core;

import java.lang.reflect.Field;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeField;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeField;
import au.net.netstorm.boost.spider.core.Provider;
import au.net.netstorm.boost.spider.inject.core.Injector;
import au.net.netstorm.boost.spider.inject.newer.core.NewerProxySupplier;
import au.net.netstorm.boost.spider.resolve.Registry;
import au.net.netstorm.boost.spider.resolve.Resolver;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;

// FIX 1676 Test drive.  This triggers work on "compose".
public final class DefaultSpider implements Spider {
    private final Provider provider;
    private final Injector injector;
    private final Resolver resolver;
    private final Registry registry;
    private final NewerProxySupplier newerSupplier;

    public DefaultSpider(Provider provider, Injector injector, Resolver resolver, Registry registry, NewerProxySupplier newerSupplier) {
        this.provider = provider;
        this.injector = injector;
        this.resolver = resolver;
        this.registry = registry;
        this.newerSupplier = newerSupplier;
    }

    public Object provide(Class type, Object[] parameters) {
        return provider.provide(type, parameters);
    }

    public void inject(Object ref) {
        injector.inject(ref);
    }

    public Object resolve(Class type) {
        return resolver.resolve(type);
    }

    public void prototype(Class iface, Class impl) {
        registry.prototype(iface, impl);
    }

    public void instance(Class iface, Object ref) {
        registry.instance(iface, ref);
    }

    public Object provideNewer(Class newerType, Object newerContainer) {
        EdgeField edgeField = new DefaultEdgeField();
        EdgeClass edgeClass = new DefaultEdgeClass();
        Field classToNuField = edgeClass.getDeclaredField(newerType, "CLASS_TO_NU");
        classToNuField.setAccessible(true);
        Class classToNu = (Class) edgeField.get(classToNuField, newerContainer);
        return newerSupplier.nu(new DefaultInterface(newerType), new DefaultImplementation(classToNu));
    }
}
