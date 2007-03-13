package au.net.netstorm.boost.demo.pebble.newer;

import au.net.netstorm.boost.pebble.core.PebbleProvider;
import junit.framework.TestCase;

public final class DefaultNewerDemoTest extends TestCase {
    private static final Object[] NO_PARAMETERS = new Object[]{};
    private final PebbleProviderAssembler pebbleProviderAssembler = new DefaultPebbleProviderAssembler();
    private final PebbleProvider pebbleProvider = pebbleProviderAssembler.assemble();

    public void testRecursiveNewerInjection() {
        Rob rob = (Rob) pebbleProvider.provide(Rob.class, NO_PARAMETERS);
        rob.checkNewerHasBeenPopulated();
        checkNewersRecurse(rob);
    }

    private void checkNewersRecurse(Rob rob) {
        Bob bob = rob.getBob();
        NewHeadJob newJobNewer = bob.getNewHeadJob();
        checkCreatedRecursively(newJobNewer);
    }

    private void checkCreatedRecursively(Object ref) {
        assertNotNull(ref);
    }
}
