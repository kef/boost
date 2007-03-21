package au.net.netstorm.boost.demo.pebble.newer;

import au.net.netstorm.boost.demo.pebble.core.PebblePortal;
import au.net.netstorm.boost.pebble.core.Pebble;
import au.net.netstorm.boost.pebble.core.PebbleProvider;
import au.net.netstorm.boost.pebble.inject.resolver.core.DefaultExplicitImplementationLookup;
import au.net.netstorm.boost.pebble.inject.resolver.core.ImplementationLookup;
import junit.framework.TestCase;

public final class DefaultNewerDemoTest extends TestCase {
    private static final Object[] NO_PARAMETERS = new Object[]{};
    private final ImplementationLookup implementationLookup = new DefaultExplicitImplementationLookup();
    private final PebbleAssembler pebbleAssembler = new DefaultPebbleAssembler(Pebble.class, implementationLookup);
    private final PebblePortal pebblePortal = pebbleAssembler.assemble();
    private final PebbleProvider pebbleProvider = pebblePortal.getProvider();

    public void testRecursiveNewerInjection() {
        Rob rob = (Rob) pebbleProvider.provide(Rob.class, NO_PARAMETERS);
        Bob bob = rob.getBob();
        checkNewersRecurse(bob);
    }

    private void checkNewersRecurse(Bob bob) {
        NewHeadJob newJobNewer = bob.getNewHeadJob();
        checkCreatedRecursively(newJobNewer);
    }

    private void checkCreatedRecursively(Object ref) {
        assertNotNull(ref);
    }
}
