package au.net.netstorm.boost.demo.pebble.newer;

import au.net.netstorm.boost.demo.pebble.core.Spidery;
import au.net.netstorm.boost.pebble.core.Citizen;
import junit.framework.TestCase;

public final class DefaultNewerDemoTest extends TestCase {
    private static final Object[] NO_PARAMETERS = new Object[]{};
    private final PebbleAssembler assembler = new DefaultPebbleAssembler(Citizen.class);
    private final Spidery spider = assembler.assemble();

    public void testRecursiveNewerInjection() {
        Rob rob = (Rob) spider.provide(Rob.class, NO_PARAMETERS);
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
