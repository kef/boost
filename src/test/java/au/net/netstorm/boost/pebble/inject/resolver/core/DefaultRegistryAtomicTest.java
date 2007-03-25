package au.net.netstorm.boost.pebble.inject.resolver.core;

import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInstance;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Instance;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultRegistryAtomicTest extends InteractionTestCase {
    Registry subject;
    Class frenchCloison = FrenchCloison.class;
    Class frenchRoll = FrenchRoll.class;
    Class davidPetit = DavidPetit.class;
    Damien damienInstance = new Damien();
    Interface cloisonInterface = new DefaultInterface(frenchCloison);
    Interface rollInterface = new DefaultInterface(frenchRoll);
    Implementation cloisonImplementation = new DefaultImplementation(davidPetit);
    Instance rollInstance = new DefaultInstance(damienInstance);
    Class iface;
    RegisterMaster registerMaster;
    Boolean hasImplementation;
    Boolean hasInstance;
    Interface someInterface;
    Implementation implementation;
    Instance instance;
    Class implClass;
    Object ref;

    public void setupSubjects() {
        subject = new DefaultRegistry(registerMaster);
    }

    public void testHasImplementation() {
        expect.oneCall(registerMaster, hasImplementation, "hasImplementation", cloisonInterface);
        Boolean result = subject.hasImplementation(cloisonInterface);
        assertEquals(hasImplementation, result);
    }

    public void testHasInstance() {
        expect.oneCall(registerMaster, hasInstance, "hasInstance", rollInterface);
        Boolean result = subject.hasInstance(rollInterface);
        assertEquals(hasInstance, result);
    }

    public void testGetImplementation() {
        expect.oneCall(registerMaster, implementation, "getImplementation", someInterface);
        Implementation result = subject.getImplementation(someInterface);
        assertEquals(implementation, result);
    }

    public void testGetInstance() {
        expect.oneCall(registerMaster, instance, "getInstance", someInterface);
        Instance result = subject.getInstance(someInterface);
        assertEquals(instance, result);
    }

    public void testPrototype() {
        expect.oneCall(registerMaster, VOID, "prototype", cloisonInterface, cloisonImplementation);
        subject.prototype(frenchCloison, davidPetit);
    }

    public void testInstance() {
        expect.oneCall(registerMaster, VOID, "instance", rollInterface, rollInstance);
        subject.instance(frenchRoll, damienInstance);
    }
}
