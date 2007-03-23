package au.net.netstorm.boost.pebble.inject.resolver.core;

import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

// FIX BREADCRUMB 1824 Complete.
public final class DefaultRegistryFacadeAtomicTest extends InteractionTestCase {
    private RegistryFacade subject;
    private Interface cloisonInterface = new DefaultInterface(FrenchCloison.class);
    private Interface rollInterface = new DefaultInterface(FrenchRoll.class);
    private Class iface;
    private RegistryEngine registryEngine;
    private boolean hasImplementation;
    private boolean hasInstance;
    private Interface someInterface;
    private Implementation implementation;

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
}
