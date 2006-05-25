package au.net.netstorm.boost.test.suite.collector;

import au.net.netstorm.boost.test.primordial.PrimordialTestCase;
import junit.framework.Test;
import junit.framework.TestSuite;

// FIXME: SC043 Sort out hang when we run this inside the IDE.
// FIXME: SC043 Boost does not need all of these, but most projects do/might.  Rationalise this.
// FIXME: SC043 Move all these into a collector subpackage.

public class AllTestSuite extends PrimordialTestCase {
    public static Test suite() {
        TestSuite suite = new TestSuite("The Whole Box and Dice");
        suite.addTest(AtomicTestSuite.suite());
        return suite;
    }
}
