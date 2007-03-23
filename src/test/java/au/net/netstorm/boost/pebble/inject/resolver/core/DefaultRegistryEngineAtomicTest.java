package au.net.netstorm.boost.pebble.inject.resolver.core;

import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInstance;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Instance;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultRegistryEngineAtomicTest extends InteractionTestCase {
    private RegistryEngine subject;
    private Class frenchCloison = FrenchCloison.class;
    private Class frenchRoll = FrenchRoll.class;
    private Class davidPetit = DavidPetit.class;
    private Damien damienInstance = new Damien();
    private Interface cloisonInterface = new DefaultInterface(frenchCloison);
    private Interface rollInterface = new DefaultInterface(frenchRoll);
    private Implementation cloisonImplementation = new DefaultImplementation(davidPetit);
    private Instance rollInstance = new DefaultInstance(damienInstance);
    private Class iface;
    private RegistryFinder registryFinder;
    private Boolean hasImplementation;
    private Boolean hasInstance;
    private Interface someInterface;
    private Implementation implementation;
    private Instance instance;
    private Class implClass;
    private Object ref;

    public void setupSubjects() {
        subject = new DefaultRegistryEngine(registryFinder);
    }

    public void testHasImplementation() {
        expect.oneCall(registryFinder, hasImplementation, "hasImplementation", cloisonInterface);
        Boolean result = subject.hasImplementation(cloisonInterface);
        assertEquals(hasImplementation, result);
    }

    public void testHasInstance() {
        expect.oneCall(registryFinder, hasInstance, "hasInstance", rollInterface);
        Boolean result = subject.hasInstance(rollInterface);
        assertEquals(hasInstance, result);
    }

    public void testGetImplementation() {
        expect.oneCall(registryFinder, implementation, "getImplementation", someInterface);
        Implementation result = subject.getImplementation(someInterface);
        assertEquals(implementation, result);
    }

    public void testGetInstance() {
        expect.oneCall(registryFinder, instance, "getInstance", someInterface);
        Instance result = subject.getInstance(someInterface);
        assertEquals(instance, result);
    }

    public void testPrototype() {
        expect.oneCall(registryFinder, VOID, "prototype", cloisonInterface, cloisonImplementation);
        subject.prototype(frenchCloison, davidPetit);
    }

    public void testInstance() {
        expect.oneCall(registryFinder, VOID, "instance", rollInterface, rollInstance);
        subject.instance(frenchRoll, damienInstance);
    }
}
