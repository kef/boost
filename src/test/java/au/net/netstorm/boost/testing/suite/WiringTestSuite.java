package au.net.netstorm.boost.testing.suite;

import au.net.netstorm.boost.testing.aggregator.TestSuiteAggregator;
import au.net.netstorm.boost.primordial.PrimordialTestCase;
import junit.framework.Test;
import junit.framework.TestSuite;

public class WiringTestSuite extends PrimordialTestCase {
    public static Test suite() {
        TestSuite suite = new TestSuite("Wiring");
        add(suite, "Wiring", ".*WiringTest");
        add(suite, "Wirer", ".*WirerTest");
        return suite;
    }

    private static void add(TestSuite suite, String name, String pattern) {
        Test test = TestSuiteAggregator.aggregate(name, pattern);
        suite.addTest(test);
    }
}
