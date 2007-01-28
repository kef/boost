package au.net.netstorm.boost.demo.pebble;

import au.net.netstorm.boost.nursery.pebble.DefaultPebbleChecker;
import au.net.netstorm.boost.nursery.pebble.NoNewInterfaceException;
import au.net.netstorm.boost.nursery.pebble.PebbleChecker;
import junit.framework.TestCase;

public final class PebbleDemoTest extends TestCase {
    private PebbleChecker pebbleChecker = new DefaultPebbleChecker();

    public void testPebble() {
        pebbleChecker.check(DefaultFroggy.class);
    }

    public void testMustHaveAssociatedNewInterface() {
        try {
            pebbleChecker.check(DefaultPricklyWithNoNewInterface.class);
            fail();
        } catch (NoNewInterfaceException expected) {
        }
    }

    // FIX 1665 Test pebble with no "new" interface.
    // FIX 1665 Single constructor.
    // FIX 1665 Interface "_" method must match signature of single constructor.
}
