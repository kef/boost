package au.net.netstorm.boost.demo.pebble;

import au.net.netstorm.boost.pebble.DefaultPebbleChecker;
import au.net.netstorm.boost.pebble.pebble.NoNewerInterfaceException;
import au.net.netstorm.boost.pebble.pebble.PebbleChecker;
import au.net.netstorm.boost.pebble.pebble.NonMatchingCreatorException;
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
        } catch (NoNewerInterfaceException expected) {
        }
    }

    public void testMustHaveCreatorWhichMatchesConstructor() {
        try {
            pebbleChecker.check(DefaultPricklyWithNonMatchingParams.class);
            fail();
        } catch (NonMatchingCreatorException expected) {
        }
    }
}
