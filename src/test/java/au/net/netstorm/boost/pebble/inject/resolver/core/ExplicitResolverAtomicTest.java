package au.net.netstorm.boost.pebble.inject.resolver.core;

import au.net.netstorm.boost.pebble.type.DefaultImplementation;
import au.net.netstorm.boost.pebble.type.Implementation;
import au.net.netstorm.boost.test.automock.BoooostTestCase;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class ExplicitResolverAtomicTest extends BoooostTestCase {
    private final ExplicitResolver resolver = new DefaultExplicitResolver();

    {
        resolver.add(LazyBastard.class, Larry.class);
        resolver.add(Legend.class, DomainBastin.class);
    }

    // FIX 1715 Fail if iface is not an interface.
    public void testResolve() {
        Implementation result = resolve(resolver, LazyBastard.class);
        checkEquals(Larry.class, result);
    }

    private void checkEquals(Class cls, Implementation result) {
        Implementation expected = new DefaultImplementation(cls);
        assertEquals(expected, result);
    }

    private Implementation resolve(Resolver resolver, Class cls) {
        Interface iface = new DefaultInterface(cls);
        return resolver.resolve(iface);
    }
}
