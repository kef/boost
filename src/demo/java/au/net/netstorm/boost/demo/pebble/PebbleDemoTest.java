package au.net.netstorm.boost.demo.pebble;

import au.net.netstorm.boost.nursery.pebble.DefaultPebbleChecker;
import au.net.netstorm.boost.nursery.pebble.PebbleChecker;
import junit.framework.TestCase;

public final class PebbleDemoTest extends TestCase {
    public void testPebble() {
        PebbleChecker pebbleChecker = new DefaultPebbleChecker();
        pebbleChecker.check(DefaultFroggy.class);
    }

    // FIX 1665 Test pebble with no "new" interface.
    // FIX 1665 Single constructor.
}
