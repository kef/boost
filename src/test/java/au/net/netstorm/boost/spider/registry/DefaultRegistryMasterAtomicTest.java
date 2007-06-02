package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.spider.flavour.Flavour;
import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.UsesAutoMocks;
import au.net.netstorm.boost.util.type.DefaultBaseReference;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;
import au.net.netstorm.boost.util.type.ResolvedInstance;

public final class DefaultRegistryMasterAtomicTest extends InteractionTestCase implements UsesAutoMocks, HasSubjects {
    private static final Interface ANIMAL = new DefaultInterface(Animal.class);
    private static final Interface SPORT = new DefaultInterface(Sport.class);
    private static final Interface VEHICLE = new DefaultInterface(Vehicle.class);
    private static final Interface BREAKFAST_CEREAL = new DefaultInterface(BreakfastCereal.class);
    private static final Interface MATRYOSHKA = new DefaultInterface(Matryoshka.class);
    private static final Implementation MAMMAL_IMPL = new DefaultImplementation(Mammal.class);
    private static final Implementation CROCODILE_IMPL = new DefaultImplementation(Crocodile.class);
    private static final Implementation CAR_IMPL = new DefaultImplementation(Car.class);
    private static final Sport FOOTBALL = new Football();
    private static final BreakfastCereal COCO_POPS = new CocoPops();
    private static final ResolvedInstance FOOTBALL_INSTANCE = new DefaultBaseReference(FOOTBALL);
    private static final ResolvedInstance COCO_POPS_INSTANCE = new DefaultBaseReference(COCO_POPS);
    private static final ResolvedInstance MATRYOSKA_INSTANCE = new DefaultBaseReference(Matryoshka.class);
    RegistryMaster subject;
    Flavour flavour;

    public void setupSubjects() {
        subject = new DefaultRegistryMaster();
        multiple(ANIMAL, MAMMAL_IMPL);
        multiple(VEHICLE, CAR_IMPL);
        instance(SPORT, FOOTBALL_INSTANCE);
        instance(BREAKFAST_CEREAL, COCO_POPS_INSTANCE);
    }

    public void testGetImplementation() {
        checkGetImplementation(ANIMAL, MAMMAL_IMPL);
        checkGetImplementation(VEHICLE, CAR_IMPL);
    }

    public void testGetInstance() {
        checkGetInstance(SPORT, FOOTBALL_INSTANCE);
        checkGetInstance(BREAKFAST_CEREAL, COCO_POPS_INSTANCE);
    }

    public void testImplImplementsInterfaceFails() {
        try {
            multiple(MATRYOSHKA, CROCODILE_IMPL);
            fail();
        } catch (WrongInterfaceRegistrationException expected) { }
    }

    public void testInstanceImplementsInterfaceFails() {
        try {
            instance(MATRYOSHKA, FOOTBALL_INSTANCE);
            fail();
        } catch (WrongInterfaceRegistrationException expected) { }
    }

    public void testNotInstance() {
        try {
            subject.getInstance(ANIMAL, flavour);
            fail();
        } catch (WrongRegistrationTypeException expected) { }
    }

    public void testNotImplementation() {
        try {
            subject.getImplementation(BREAKFAST_CEREAL, flavour);
            fail();
        } catch (WrongRegistrationTypeException expected) { }
    }

    public void testHasInstance() {
        checkHasInstance(SPORT, true);
        checkHasInstance(ANIMAL, false);
    }

    public void testHasImplementation() {
        checkHasImplementation(SPORT, false);
        checkHasImplementation(ANIMAL, true);
    }

    private void checkHasImplementation(Interface iface, boolean expected) {
        boolean result = subject.hasImplementation(iface, flavour);
        assertEquals(expected, result);
    }

    private void checkHasInstance(Interface iface, boolean expected) {
        boolean result = subject.hasInstance(iface, flavour);
        assertEquals(expected, result);
    }

    private void checkGetInstance(Interface iface, ResolvedInstance expect) {
        ResolvedInstance result = subject.getInstance(iface, flavour);
        assertEquals(expect, result);
    }

    private void checkGetImplementation(Interface iface, Implementation expected) {
        Implementation result = subject.getImplementation(iface, flavour);
        checkEquals(expected, result);
    }

    private void checkEquals(Implementation expected, Implementation result) {
        assertEquals(expected, result);
    }

    private void instance(Interface iface, ResolvedInstance instance) {
        subject.instance(iface, instance, flavour);
    }

    private void multiple(Interface iface, Implementation impl) {
        subject.multiple(iface, impl, flavour);
    }
}
