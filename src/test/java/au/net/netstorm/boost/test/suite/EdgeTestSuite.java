package au.net.netstorm.boost.test.suite;

import au.net.netstorm.boost.test.aggregator.TestAggregator;
import au.net.netstorm.boost.test.primordial.PrimordialTestCase;
import junit.framework.Test;

public class EdgeTestSuite extends PrimordialTestCase {
    public static Test suite() {
        return TestAggregator.aggregate("Edge", ".*EdgeTest");
    }
}
