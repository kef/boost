package au.net.netstorm.boost.test.suite;

import au.net.netstorm.boost.test.aggregator.TestAggregator;
import au.net.netstorm.boost.test.primordial.PrimordialTestCase;
import junit.framework.Test;
import junit.framework.TestSuite;

public class SlowTestSuite extends PrimordialTestCase {
    public static Test suite() {
        TestSuite suite = new TestSuite("Slow");
        suite.addTest(new TestAggregator().aggregate("Edge", ".*EdgeTest"));
//        suite.addTest(IntegrationTestSuite.suite());
//        suite.addTest(AcceptanceTestSuite.suite());
        return suite;
    }
}
