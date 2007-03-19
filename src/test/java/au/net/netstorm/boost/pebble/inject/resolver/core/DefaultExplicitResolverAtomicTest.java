package au.net.netstorm.boost.pebble.inject.resolver.core;

import java.util.Map;
import au.net.netstorm.boost.pebble.type.DefaultImplementation;
import au.net.netstorm.boost.pebble.type.Implementation;
import au.net.netstorm.boost.test.cases.BoooostCase;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultExplicitResolverAtomicTest extends BoooostCase {
    private static final Class LAZY_BASTARD = LazyBastard.class;
    private static final Class LARRY = Larry.class;
    private static final Class LEGEND = Legend.class;
    private static final Class AN_DO = AnDo.class;
    private static final Interface NON_EXISTENT = new DefaultInterface(Map.class);
    private final ExplicitResolver subject = new DefaultExplicitResolver();

    {
        subject.add(LAZY_BASTARD, LARRY);
        subject.add(LEGEND, AN_DO);
    }

    public void testResolve() {
        checkResolve(LAZY_BASTARD, LARRY);
        checkResolve(LEGEND, AN_DO);
    }

    public void testCannotResolve() {
        try {
            subject.resolve(NON_EXISTENT);
            fail();
        } catch (UnresolvedDependencyException expected) { }
    }

    public void testMustBeInterface() {
        try {
            subject.add(LARRY, LARRY);
            fail();
        } catch (IllegalArgumentException expected) { }
    }

    private void checkResolve(Class iface, Class impl) {
        Implementation result = resolve(subject, iface);
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
