package au.net.netstorm.boost.pebble.inject.resolver.core;

import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeField;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeField;
import au.net.netstorm.boost.pebble.core.PebbleProvider;
import au.net.netstorm.boost.pebble.inject.newer.core.Injector;
import au.net.netstorm.boost.pebble.inject.resolver.field.ResolverFieldFinder;

public final class ResolverInjector implements Injector {
    private final EdgeField fielder = new DefaultEdgeField();
    private final ResolverFieldFinder fieldFinder;
    private final PebbleProvider provider = null;
    private final Resolver resolver;

    public ResolverInjector(ResolverFieldFinder fieldFinder, Resolver resolver) {
        this.fieldFinder = fieldFinder;
        this.resolver = resolver;
    }

    public void inject(Object ref) {
        // FIX 1715 Do this.
        // FIX 1715 Nail 4 next.
        // 1. For each candidate field.
        // 2. Determine field interface.
        // 4. Instantiate implementation.
        // 5. Set field.
    }

    // FIX 1715 Use this as a guide.
/*
    private void doInject(Object ref) {
        Field[] fields = fieldFinder.find(ref);
        for (int i = 0; i < fields.length; i++) {
            inject(ref, fields[i]);
        }
    }

    private void inject(Object ref, Field field) {
        Class type = field.getType();
        Interface iface = new DefaultInterface(type);
        Object value = resolve(iface);
        fielder.set(field, ref, value);
    }

    // FIX 1715 This is the true resolver?
    private Object resolve(Interface iface) {
        Implementation implementation = resolver.resolve(iface);
        return create(implementation);
    }

    private Object create(Implementation implementation) {
        Object[] parameters = { };
        Class impl = implementation.getImpl();
        return provider.provide(impl, parameters);
    }
*/
    // FIX 1715 Remove when done.
}
