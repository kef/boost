package au.net.netstorm.boost.testing.suite;

import au.net.netstorm.boost.primordial.PrimordialTestCase;
import junit.framework.Test;
import junit.framework.TestSuite;

public class QuickTestSuite extends PrimordialTestCase {
    public static Test suite() {
        TestSuite suite = new TestSuite("Quick");
        suite.addTest(AtomicTestSuite.suite());
//        suite.addTest(WiringTestSuite.suite());
        suite.addTest(EnvironmentTestSuite.suite());
        return suite;
    }
}
