package au.net.netstorm.boost.pebble.inject.resolver.core;

import au.net.netstorm.boost.pebble.type.DefaultImplementation;
import au.net.netstorm.boost.pebble.type.Implementation;
import au.net.netstorm.boost.test.automock.BoooostTestCase;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultExplicitResolverAtomicTest extends BoooostTestCase {
    private static final Class LAZY_BASTARD = LazyBastard.class;
    private static final Class LARRY = Larry.class;
    private static final Class LEGEND = Legend.class;
    private static final Class AN_DO = AnDo.class;
    private final ExplicitResolver resolver = new DefaultExplicitResolver();

    {
        resolver.add(LAZY_BASTARD, LARRY);
        resolver.add(LEGEND, AN_DO);
    }

    // FIX 1715 Fail if iface is not an interface.
    public void testResolve() {
        checkResolve(LAZY_BASTARD, LARRY);
        checkResolve(LEGEND, AN_DO);
    }

    private void checkResolve(Class iface, Class impl) {
        Implementation result = resolve(resolver, iface);
        checkEquals(impl, result);
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
