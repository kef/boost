package au.net.netstorm.boost.pebble.inject.resolver.core;

import junit.framework.TestCase;

public final class DefaultFieldResolverAtomicTest extends TestCase {

    public void testResolve() {
        // FIX BREADCRUMB 1715 Complete me. 
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
