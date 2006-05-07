package au.net.netstorm.boost.test.suite;

import au.net.netstorm.boost.test.primordial.PrimordialTestCase;
import junit.framework.Test;
import junit.framework.TestSuite;

// FIXME: SC043 Sort out hang when we run this inside the IDE.
// FIXME: SC043 Boost does not need all of these, but most project do/might.  Rationalise this.

public class AllTestSuite extends PrimordialTestCase {
    public static Test suite() {
        TestSuite suite = new TestSuite("The Whole Box and Dice");
        suite.addTest(QuickTestSuite.suite());
        suite.addTest(SlowTestSuite.suite());
        return suite;
    }
}
