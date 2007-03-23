package au.net.netstorm.boost.pebble.inject.resolver.core;

import au.net.netstorm.boost.test.automock.InteractionTestCase;

public final class DefaultRegistryFacadeAtomicTest extends InteractionTestCase {
    private RegistryFacade subject;
    private Class iface;

    public void setupSubjects() {
        subject = new DefaultRegistryFacade();
    }

    // FIX BREADCRUMB 1824 Complete.
    public void testHasImplementation() {
        subject.hasImplementation(iface);
    }
}
