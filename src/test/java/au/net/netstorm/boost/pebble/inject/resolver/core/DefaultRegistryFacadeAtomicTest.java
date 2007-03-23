package au.net.netstorm.boost.pebble.inject.resolver.core;

import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

// FIX BREADCRUMB 1824 Complete.
public final class DefaultRegistryFacadeAtomicTest extends InteractionTestCase {
    private RegistryFacade subject;
    private Interface inyerface = new DefaultInterface(FrenchCloison.class);
    private Class iface;
    private RegistryEngine registryEngine;
    private boolean hasImplementation;

    public void setupSubjects() {
        subject = new DefaultRegistryFacade(registryEngine);
    }

    public void testHasImplementation() {
        expect.oneCall(registryEngine, hasImplementation, "hasImplementation", inyerface);
        boolean result = subject.hasImplementation(FrenchCloison.class);
        assertEquals(hasImplementation, result);
    }
}
