package au.net.netstorm.boost.demo.pebble.check;

import au.net.netstorm.boost.spider.core.DefaultPebbleChecker;
import au.net.netstorm.boost.spider.core.PebbleChecker;
import au.net.netstorm.boost.spider.type.NoNewerInterfaceException;
import au.net.netstorm.boost.spider.type.NonMatchingNewerException;
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

    public void testMustHaveNewerWhichMatchesConstructor() {
        try {
            pebbleChecker.check(DefaultPricklyWithNonMatchingParams.class);
            fail();
        } catch (NonMatchingNewerException expected) {
        }
    }
}
