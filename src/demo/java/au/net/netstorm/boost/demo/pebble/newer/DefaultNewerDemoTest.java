package au.net.netstorm.boost.demo.pebble.newer;

import au.net.netstorm.boost.pebble.newer.core.ObjectProvider;
import junit.framework.TestCase;

public final class DefaultNewerDemoTest extends TestCase {
    private static final Object[] NO_PARAMETERS = new Object[]{};
    private final ObjectProviderAssembler objectProviderAssembler = new DefaultObjectProviderAssembler();
    private final ObjectProvider objectProvider = objectProviderAssembler.assemble();

    public void testRecursiveNewerInjection() {
        Rob rob = (Rob) objectProvider.provide(Rob.class, NO_PARAMETERS);
        rob.checkNewerHasBeenPopulated();
        checkNewersRecurse(rob);
    }

    private void checkNewersRecurse(Rob rob) {
        Bob bob = rob.getBob();
        NewHeadJob newJobNewer = bob.getNewHeadJob();
        assertNotNull("newJobNewer should have been created as a dependency", newJobNewer);
    }
}
