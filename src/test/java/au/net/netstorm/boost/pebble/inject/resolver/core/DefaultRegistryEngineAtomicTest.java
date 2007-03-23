package au.net.netstorm.boost.pebble.inject.resolver.core;

import java.util.Map;
import au.net.netstorm.boost.test.cases.BoooostCase;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInstance;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Instance;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultRegistryEngineAtomicTest extends BoooostCase {
    private static final Class LAZY_BASTARD = LazyBastard.class;
    private static final Class LARRY = Larry.class;
    private static final Class LEGEND = Legend.class;
    private static final Class AN_DO = AnDo.class;
    private static final FrenchCloison DAVID_PETIT_REF = new DavidPetit();
    private static final Class FRENCH_CLOISON = FrenchCloison.class;
    private static final Class FRENCH_ROLL = FrenchRoll.class;
    private static final Instance DAVID_PETIT = new DefaultInstance(DAVID_PETIT_REF);
    private static final FrenchRoll DAMIEN_REF = new Damien();
    private static final Instance DAMIEN = new DefaultInstance(DAMIEN_REF);

    private static final Interface NON_EXISTENT = new DefaultInterface(Map.class);

    private final RegistryEngine subject = new DefaultRegistryEngine();

    {
        subject.prototype(LAZY_BASTARD, LARRY);
        subject.prototype(LEGEND, AN_DO);
        subject.instance(FRENCH_CLOISON, DAVID_PETIT);
        subject.instance(FRENCH_ROLL, DAMIEN);
    }

    public void testGetImplementation() {
        checkGetImplementation(LAZY_BASTARD, LARRY);
        checkGetImplementation(LEGEND, AN_DO);
    }

    // FIX BREADCRUMB 1824 Make sure no one can add an existing instance.
    public void testGetInstance() {
        checkGetInstance(FRENCH_CLOISON, DAVID_PETIT);
        checkGetInstance(FRENCH_ROLL, DAMIEN);
    }

    private void checkGetInstance(Class iface, Instance expect) {
        Interface iface1 = new DefaultInterface(iface);
        Instance result = subject.getInstance(iface1);
        assertEquals(expect, result);
    }

    public void testCannotGetImplementation() {
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

    private void checkGetImplementation(Class iface, Class impl) {
        Implementation result = getImplementation(iface);
        checkEquals(impl, result);
    }

    private void checkEquals(Class cls, Implementation result) {
        Implementation expected = new DefaultImplementation(cls);
        assertEquals(expected, result);
    }

    private Implementation getImplementation(Class cls) {
        Interface iface = new DefaultInterface(cls);
        return subject.getImplementation(iface);
    }
}
