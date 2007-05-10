package au.net.netstorm.boost.spider.resolve;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import au.net.netstorm.boost.spider.inject.resolver.core.AlreadyRegisteredException;
import au.net.netstorm.boost.test.cases.BoooostCase;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultRegistryMasterAtomicTest extends BoooostCase {
    private static final Interface ANIMAL = new DefaultInterface(Animal.class);
    private static final Interface SPORT = new DefaultInterface(Sport.class);
    private static final Interface VEHICLE = new DefaultInterface(Vehicle.class);
    private static final Interface BREAKFAST_CEREAL = new DefaultInterface(BreakfastCereal.class);
    private static final Interface NON_EXISTENT = new DefaultInterface(Map.class);
    private static final Interface MATRYOSHKA = new DefaultInterface(Matryoshka.class);
    private static final Interface JACK = new DefaultInterface(Jack.class);
    private static final Implementation MAMMAL_IMPL = new DefaultImplementation(Mammal.class);
    private static final Implementation CROCODILE_IMPL = new DefaultImplementation(Crocodile.class);
    private static final Implementation JACK_IMPL = new DefaultImplementation(OneArgJack.class);
    private static final Implementation CAR_IMPL = new DefaultImplementation(Car.class);
    private static final Sport FOOTBALL = new Football();
    private static final BreakfastCereal COCO_POPS = new CocoPops();
    private static final ResolvedInstance FOOTBALL_INSTANCE = new DefaultBaseReference(FOOTBALL);
    private static final ResolvedInstance COCO_POPS_INSTANCE = new DefaultBaseReference(COCO_POPS);
    private static final ResolvedInstance MATRYOSKA_INSTANCE = new DefaultBaseReference(Matryoshka.class);
    private final RegistryMaster subject = new DefaultRegistryMaster();

    {
        subject.implementation(ANIMAL, MAMMAL_IMPL);
        subject.implementation(VEHICLE, CAR_IMPL);
        subject.instance(SPORT, FOOTBALL_INSTANCE);
        subject.instance(BREAKFAST_CEREAL, COCO_POPS_INSTANCE);
    }

    public void testGetImplementation() {
        checkGetImplementation(ANIMAL, MAMMAL_IMPL);
        checkGetImplementation(VEHICLE, CAR_IMPL);
    }

    public void testGetInstance() {
        checkGetInstance(SPORT, FOOTBALL_INSTANCE);
        checkGetInstance(BREAKFAST_CEREAL, COCO_POPS_INSTANCE);
    }

    public void testDuplicateInstance() {
        try {
            subject.instance(BREAKFAST_CEREAL, COCO_POPS_INSTANCE);
            fail();
        } catch (AlreadyRegisteredException expected) { }
    }

    public void testDuplicateImplementation() {
        try {
            subject.implementation(ANIMAL, CROCODILE_IMPL);
            fail();
        } catch (AlreadyRegisteredException expected) {}
    }

    public void testImplImplementsInterfaceFails() {
        try {
            subject.implementation(MATRYOSHKA, CROCODILE_IMPL);
            fail();
        } catch (WrongInterfaceRegistrationException expected) { }
    }

    public void testInstanceImplementsInterfaceFails() {
        try {
            subject.instance(MATRYOSHKA, FOOTBALL_INSTANCE);
            fail();
        } catch (WrongInterfaceRegistrationException expected) { }
    }

    public void testClassInstanceFails() {
        try {
            subject.instance(MATRYOSHKA, MATRYOSKA_INSTANCE);
            fail();
        } catch (WrongInstanceTypeException expected) {
            String actualMessage = MATRYOSKA_INSTANCE.getRef() + " is a class and cannot be registered as an instance.";
            String expectedMessage = expected.getMessage();
            assertEquals(expectedMessage, actualMessage);
        }
    }

    public void testNotInstance() {
        try {
            subject.getInstance(ANIMAL);
            fail();
        } catch (WrongRegistrationTypeException expected) { }
    }

    public void testNotImplementation() {
        try {
            subject.getImplementation(BREAKFAST_CEREAL);
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
        checkHasInstance(SPORT, true);
        checkHasInstance(ANIMAL, false);
    }

    public void testHasImplementation() {
        checkHasImplementation(ANIMAL, true);
        checkHasImplementation(SPORT, false);
    }

    public void testElements() {
        Interface[] result = subject.getKeys();
        Interface[] expected = new Interface[]{VEHICLE, ANIMAL, SPORT, BREAKFAST_CEREAL};
        checkElements(expected, result);
    }

    private void checkElements(Interface[] expected, Interface[] actual) {
        assertEquals(expected.length, actual.length);
        List actualAsList = Arrays.asList(actual);
        for (int i = 0; i < expected.length; i++) {
            Interface inyerface = expected[i];
            assertEquals(true, actualAsList.contains(inyerface));
        }
    }

    private void checkHasImplementation(Interface iface, boolean expected) {
        boolean result = subject.hasImplementation(iface);
        assertEquals(expected, result);
    }

    private void checkHasInstance(Interface iface, boolean expected) {
        boolean result = subject.hasInstance(iface);
        assertEquals(expected, result);
    }

    private void checkGetInstance(Interface iface, ResolvedInstance expect) {
        ResolvedInstance result = subject.getInstance(iface);
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
