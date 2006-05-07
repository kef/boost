package au.net.netstorm.boost.test.suite;

import au.net.netstorm.boost.test.aggregator.DefaultTestAggregator;
import au.net.netstorm.boost.test.primordial.PrimordialTestCase;
import junit.framework.Test;
import junit.framework.TestSuite;

public class SlowTestSuite extends PrimordialTestCase {
    public static Test suite() {
        TestSuite suite = new TestSuite("Slow");
        suite.addTest(new DefaultTestAggregator().aggregate("Edge", ".*EdgeTest"));
//        suite.addTest(IntegrationTestSuite.suite());
//        suite.addTest(AcceptanceTestSuite.suite());
        return suite;
    }
}
