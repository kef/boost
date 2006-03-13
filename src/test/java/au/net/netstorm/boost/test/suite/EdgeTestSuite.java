package au.net.netstorm.boost.test.suite;

import au.net.netstorm.boost.primordial.PrimordialTestCase;
import au.net.netstorm.boost.test.aggregator.TestSuiteAggregator;
import junit.framework.Test;

public class EdgeTestSuite extends PrimordialTestCase {
    public static Test suite() {
        return TestSuiteAggregator.aggregate("Edge", ".*EdgeTest");
    }
}
