package au.net.netstorm.boost.test.suite;

import au.net.netstorm.boost.test.aggregator.DefaultTestAggregator;
import au.net.netstorm.boost.test.aggregator.TestAggregator;
import au.net.netstorm.boost.test.primordial.PrimordialTestCase;
import junit.framework.Test;
import junit.framework.TestSuite;

public class SlowTestSuite extends PrimordialTestCase {
    private static final TestAggregator AGGREGATOR = new DefaultTestAggregator();

    public static Test suite() {
        TestSuite suite = new TestSuite("Slow");
        Test edgeSuite = AGGREGATOR.aggregate("Edge", ".*EdgeTest");
        suite.addTest(edgeSuite);
        suite.addTest(IntegrationTestSuite.suite());
        suite.addTest(AcceptanceTestSuite.suite());
        return suite;
    }
}
