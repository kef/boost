package au.net.netstorm.boost.demo.pebble.newer;

import au.net.netstorm.boost.pebble.core.PebbleProvider;
import junit.framework.TestCase;

public final class DefaultNewerDemoTest extends TestCase {
    private static final Object[] NO_PARAMETERS = new Object[]{};
    private final PebbleProviderAssembler pebbleProviderAssembler = new DefaultPebbleProviderAssembler();
    private final PebbleProvider pebbleProvider = pebbleProviderAssembler.assemble();

    public void testRecursiveNewerInjection() {
        // FIX BREADCRUMB 1715 -1000000 This is the time for us to work out how to signify we want a field which is NULL.
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
