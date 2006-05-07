package au.net.netstorm.boost.test.suite;

import au.net.netstorm.boost.test.aggregator.DefaultTestAggregator;
import au.net.netstorm.boost.test.primordial.PrimordialTestCase;
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
        Test test = new DefaultTestAggregator().aggregate(name, pattern);
        suite.addTest(test);
    }
}
