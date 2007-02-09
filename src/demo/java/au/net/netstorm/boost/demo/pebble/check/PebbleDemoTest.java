package au.net.netstorm.boost.demo.pebble.check;

import au.net.netstorm.boost.nursery.pebble.core.DefaultPebbleChecker;
import au.net.netstorm.boost.nursery.pebble.core.PebbleChecker;
import au.net.netstorm.boost.nursery.pebble.type.NoCreatorInterfaceException;
import au.net.netstorm.boost.nursery.pebble.type.NonMatchingCreatorException;
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
        } catch (NoCreatorInterfaceException expected) {
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
