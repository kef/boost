package au.net.netstorm.boost.test.suite.collector;

import au.net.netstorm.boost.test.primordial.PrimordialTestCase;
import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTestSuite extends PrimordialTestCase {
    public static Test suite() {
        TestSuite suite = new TestSuite("The Whole Box and Dice");
        suite.addTest(AtomicTestSuite.suite());
        suite.addTest(DemoTestSuite.suite());
        return suite;
    }
}
