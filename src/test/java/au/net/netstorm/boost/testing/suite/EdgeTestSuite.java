package au.net.netstorm.boost.testing.suite;

import au.net.netstorm.boost.testing.aggregator.TestSuiteAggregator;
import au.net.netstorm.boost.primordial.PrimordialTestCase;
import junit.framework.Test;

public class EdgeTestSuite extends PrimordialTestCase {
    public static Test suite() {
        return TestSuiteAggregator.aggregate("Edge", ".*EdgeTest");
    }
}
