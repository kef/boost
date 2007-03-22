package au.net.netstorm.boost.pebble.inject.resolver.core;

import java.util.Map;
import au.net.netstorm.boost.test.cases.BoooostCase;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultExplicitImplementationRegistryAtomicTest extends BoooostCase {
    private static final Class LAZY_BASTARD = LazyBastard.class;
    private static final Class LARRY = Larry.class;
    private static final Class LEGEND = Legend.class;
    private static final Class AN_DO = AnDo.class;
    private static final Interface NON_EXISTENT = new DefaultInterface(Map.class);
    private final RegistryEngine subject = new DefaultRegistryEngine();

    {
        subject.prototype(LAZY_BASTARD, LARRY);
        subject.prototype(LEGEND, AN_DO);
    }

    public void testResolve() {
        checkResolve(LAZY_BASTARD, LARRY);
        checkResolve(LEGEND, AN_DO);
    }

    public void testCannotResolve() {
        try {
            subject.getImplementation(NON_EXISTENT);
            fail();
        } catch (UnresolvedDependencyException expected) { }
    }

    public void testMustBeInterface() {
        try {
            subject.prototype(LARRY, LARRY);
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

    private Implementation resolve(RegistryEngine registryEngine, Class cls) {
        Interface iface = new DefaultInterface(cls);
        return registryEngine.getImplementation(iface);
    }
}
