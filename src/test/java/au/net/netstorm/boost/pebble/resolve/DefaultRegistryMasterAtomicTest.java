package au.net.netstorm.boost.pebble.resolve;

import java.util.Map;
import au.net.netstorm.boost.pebble.inject.resolver.core.AlreadyRegisteredException;
import au.net.netstorm.boost.test.cases.BoooostCase;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Instance;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultRegistryMasterAtomicTest extends BoooostCase {
    private static final Interface LAZY_BASTARD = new DefaultInterface(LazyBastard.class);
    private static final Implementation LARRY = new DefaultImplementation(Larry.class);
    private static final Interface LEGEND = new DefaultInterface(Legend.class);
    private static final Implementation AN_DO = new DefaultImplementation(AnDo.class);
    private static final Interface FRENCH_CLOISON = new DefaultInterface(FrenchCloison.class);
    private static final Interface FRENCH_ROLL = new DefaultInterface(FrenchRoll.class);
    private static final FrenchCloison DAVID_PETIT_REF = new DavidPetit();
    private static final FrenchRoll DAMIEN_REF = new Damien();
    private static final Instance DAVID_PETIT = new DefaultBaseReference(DAVID_PETIT_REF);
    private static final Instance DAMIEN = new DefaultBaseReference(DAMIEN_REF);
    private static final Implementation GREG = new DefaultImplementation(Greg.class);
    private static final Interface NON_EXISTENT = new DefaultInterface(Map.class);
    private final RegistryMaster subject = new DefaultRegistryMaster();

    {
        subject.implementation(LAZY_BASTARD, LARRY);
        subject.implementation(LEGEND, AN_DO);
        subject.instance(FRENCH_CLOISON, DAVID_PETIT);
        subject.instance(FRENCH_ROLL, DAMIEN);
    }

    public void testGetImplementation() {
        checkGetImplementation(LAZY_BASTARD, LARRY);
        checkGetImplementation(LEGEND, AN_DO);
    }

    public void testGetInstance() {
        checkGetInstance(FRENCH_CLOISON, DAVID_PETIT);
        checkGetInstance(FRENCH_ROLL, DAMIEN);
    }

    public void testDuplicateInstance() {
        try {
            subject.instance(FRENCH_ROLL, DAMIEN);
            fail();
        } catch (AlreadyRegisteredException expected) { }
    }

    public void testDuplicateImplementation() {
        try {
            subject.implementation(LAZY_BASTARD, GREG);
            fail();
        } catch (AlreadyRegisteredException expected) {}
    }

    public void testNotInstance() {
        try {
            subject.getInstance(LAZY_BASTARD);
            fail();
        } catch (WrongRegistrationTypeException expected) { }
    }

    public void testNotImplementation() {
        try {
            subject.getImplementation(FRENCH_ROLL);
            fail();
        } catch (WrongRegistrationTypeException expected) { }
    }

    public void testInstanceDoesNotExist() {
        try {
            subject.getInstance(NON_EXISTENT);
            fail();
        } catch (UnresolvedDependencyException expected) { }
    }

    public void testHasInstance() {
        checkHasInstance(FRENCH_CLOISON, true);
        checkHasInstance(LAZY_BASTARD, false);
    }

    public void testHasImplementation() {
        checkHasImplementation(LAZY_BASTARD, true);
        checkHasImplementation(FRENCH_CLOISON, false);
    }

    private void checkHasImplementation(Interface iface, boolean expected) {
        boolean result = subject.hasImplementation(iface);
        assertEquals(expected, result);
    }

    private void checkHasInstance(Interface iface, boolean expected) {
        boolean result = subject.hasInstance(iface);
        assertEquals(expected, result);
    }

    private void checkGetInstance(Interface iface, Instance expect) {
        Instance result = subject.getInstance(iface);
        assertEquals(expect, result);
    }

    public void testCannotGetImplementation() {
        try {
            subject.getImplementation(NON_EXISTENT);
            fail();
        } catch (UnresolvedDependencyException expected) { }
    }

    private void checkGetImplementation(Interface iface, Implementation expected) {
        Implementation result = subject.getImplementation(iface);
        checkEquals(expected, result);
    }

    private void checkEquals(Implementation expected, Implementation result) {
        assertEquals(expected, result);
    }
}
