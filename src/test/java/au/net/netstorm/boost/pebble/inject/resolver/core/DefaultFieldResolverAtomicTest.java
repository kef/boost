package au.net.netstorm.boost.pebble.inject.resolver.core;

import java.lang.reflect.Field;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.test.automock.BoooostCase;

public final class DefaultFieldResolverAtomicTest extends BoooostCase {
    private final FieldResolver subject = new DefaultFieldResolver();
    private final EdgeClass classer = new DefaultEdgeClass();
    private final Field field = classer.getDeclaredField(JuicyPebble.class, "someOneIKnow");
    private final LazyBastard lazareetus = new Larry();

    public void testResolve() {
        // FIX BREADCRUMB 1715 Complete me.
        Object resolved = subject.resolve(field);
//        assertEquals(lazareetus, resolved);
    }

    // FIX 1715 Use this as a guide.

    // FIX 1715 Remove when done.
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
}
