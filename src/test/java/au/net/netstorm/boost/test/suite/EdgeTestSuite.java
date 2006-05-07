package au.net.netstorm.boost.test.suite;

import au.net.netstorm.boost.test.aggregator.DefaultTestAggregator;
import au.net.netstorm.boost.test.primordial.PrimordialTestCase;
import junit.framework.Test;

public class EdgeTestSuite extends PrimordialTestCase {
    public static Test suite() {
        return new DefaultTestAggregator().aggregate("Edge", ".*EdgeTest");
    }
}
