package au.net.netstorm.boost.demo.pebble.newer;

import au.net.netstorm.boost.demo.pebble.core.PebblePortal;
import au.net.netstorm.boost.pebble.core.Citizen;
import au.net.netstorm.boost.pebble.core.Provider;
import junit.framework.TestCase;

public final class DefaultNewerDemoTest extends TestCase {
    private static final Object[] NO_PARAMETERS = new Object[]{};
    private final PebbleAssembler assembler = new DefaultPebbleAssembler(Citizen.class);
    private final PebblePortal portal = assembler.assemble();
    private final Provider provider = portal.getProvider();

    public void testRecursiveNewerInjection() {
        Rob rob = (Rob) provider.provide(Rob.class, NO_PARAMETERS);
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
