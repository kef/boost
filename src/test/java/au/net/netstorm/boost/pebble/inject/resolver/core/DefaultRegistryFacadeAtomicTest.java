package au.net.netstorm.boost.pebble.inject.resolver.core;

import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInstance;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Instance;
import au.net.netstorm.boost.util.type.Interface;

// FIX BREADCRUMB 1824 Complete.
public final class DefaultRegistryFacadeAtomicTest extends InteractionTestCase {
    private RegistryFacade subject;
    private Class frenchCloison = FrenchCloison.class;
    private Class frenchRoll = FrenchRoll.class;
    private Class davidPetit = DavidPetit.class;
    private Damien damienInstance = new Damien();
    private Interface cloisonInterface = new DefaultInterface(frenchCloison);
    private Interface rollInterface = new DefaultInterface(frenchRoll);
    private Implementation cloisonImplementation = new DefaultImplementation(davidPetit);
    private Instance rollInstance = new DefaultInstance(damienInstance);
    private Class iface;
    private RegistryEngine registryEngine;
    private boolean hasImplementation;
    private boolean hasInstance;
    private Interface someInterface;
    private Implementation implementation;
    private Instance instance;
    private Class implClass;
    private Object ref;

    public void setupSubjects() {
        subject = new DefaultRegistryFacade(registryEngine);
    }

    public void testHasImplementation() {
        expect.oneCall(registryEngine, hasImplementation, "hasImplementation", cloisonInterface);
        boolean result = subject.hasImplementation(FrenchCloison.class);
        assertEquals(hasImplementation, result);
    }

    public void testHasInstance() {
        expect.oneCall(registryEngine, hasInstance, "hasInstance", rollInterface);
        boolean result = subject.hasInstance(FrenchRoll.class);
        assertEquals(hasInstance, result);
    }

    public void testGetImplementation() {
        expect.oneCall(registryEngine, implementation, "getImplementation", someInterface);
        Implementation result = subject.getImplementation(someInterface);
        assertEquals(implementation, result);
    }

    public void testGetInstance() {
        expect.oneCall(registryEngine, instance, "getInstance", someInterface);
        Instance result = subject.getInstance(someInterface);
        assertEquals(instance, result);
    }

    public void testPrototype() {
        expect.oneCall(registryEngine, VOID, "prototype", cloisonInterface, cloisonImplementation);
        subject.prototype(frenchCloison, davidPetit);
    }

    public void testInstance() {
        expect.oneCall(registryEngine, VOID, "instance", rollInterface, rollInstance);
        subject.instance(frenchRoll, damienInstance);
    }
}
