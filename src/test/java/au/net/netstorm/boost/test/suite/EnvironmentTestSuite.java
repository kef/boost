package au.net.netstorm.boost.test.suite;

import au.net.netstorm.boost.test.aggregator.DefaultTestAggregator;
import au.net.netstorm.boost.test.aggregator.TestAggregator;
import au.net.netstorm.boost.test.primordial.PrimordialTestCase;
import junit.framework.Test;

public class EnvironmentTestSuite extends PrimordialTestCase {
    private static final TestAggregator AGGREGATOR = new DefaultTestAggregator();

    public static Test suite() {
        return AGGREGATOR.aggregate("Environment", ".*EnvironmentTest");
    }
}
