package au.net.netstorm.boost.test.suite.collector;

import au.net.netstorm.boost.test.aggregator.DefaultTestAggregator;
import au.net.netstorm.boost.test.aggregator.TestAggregator;
import au.net.netstorm.boost.test.core.BoooostCase;
import junit.framework.Test;

// FIX SC600 Rename "build" area to "gen".
public class DemoTestSuite extends BoooostCase {
    private static final Class CLASS_IN_TEST_TREE = DemoTestSuite.class;
    private static final TestAggregator AGGREGATOR = new DefaultTestAggregator(CLASS_IN_TEST_TREE);

    public static Test suite() {
        return AGGREGATOR.aggregate("Demo", ".*DemoTest");
    }
}
