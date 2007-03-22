package au.net.netstorm.boost.demo.pebble.newer;

import au.net.netstorm.boost.demo.pebble.core.PebblePortal;
import au.net.netstorm.boost.pebble.core.Pebble;
import au.net.netstorm.boost.pebble.core.PebbleProvider;
import au.net.netstorm.boost.pebble.inject.resolver.core.DefaultExplicitImplementationRegistry;
import au.net.netstorm.boost.pebble.inject.resolver.core.ImplementationRegistry;
import junit.framework.TestCase;

public final class DefaultNewerDemoTest extends TestCase {
    private static final Object[] NO_PARAMETERS = new Object[]{};
    private final ImplementationRegistry implementationRegistry = new DefaultExplicitImplementationRegistry();
    private final PebbleAssembler pebbleProviderAssembler = new DefaultPebbleAssembler(Pebble.class, implementationRegistry);
    private final PebblePortal pebblePortal = pebbleProviderAssembler.assemble();
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
