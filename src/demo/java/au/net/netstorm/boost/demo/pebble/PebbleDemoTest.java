package au.net.netstorm.boost.demo.pebble;

import au.net.netstorm.boost.nursery.pebble.DefaultPebbleChecker;
import au.net.netstorm.boost.nursery.pebble.NoNewerInterfaceException;
import au.net.netstorm.boost.nursery.pebble.PebbleChecker;
import au.net.netstorm.boost.nursery.pebble.NonMatchingCreatorException;
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
            pebbleChecker.check(DefaultPricklyWithNonMatchingCreator.class);
            fail();
        } catch (NonMatchingCreatorException expected) {
        }
    }

    // FIX 1665 Test pebble with no "new" interface.
    // FIX 1665 Creator must be interface.
    // FIX 1665 Creator must have single method matching object constructor.


    // DONE:
    // FIX 1665 Creator method must be "_".
    // FIX 1665 Creator method "_" must match object's single constructor parameters.
}
