package au.net.netstorm.boost.testing.suite;

import au.net.netstorm.boost.primordial.PrimordialTestCase;
import au.net.netstorm.boost.testing.aggregator.TestSuiteAggregator;
import junit.framework.Test;
import junit.framework.TestSuite;

public class SlowTestSuite extends PrimordialTestCase {
    public static Test suite() {
        TestSuite suite = new TestSuite("Slow");
        suite.addTest(TestSuiteAggregator.aggregate("Edge", ".*EdgeTest"));
//        suite.addTest(IntegrationTestSuite.suite());
//        suite.addTest(AcceptanceTestSuite.suite());
        return suite;
    }
}
