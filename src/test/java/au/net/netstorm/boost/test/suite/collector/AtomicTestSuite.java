package au.net.netstorm.boost.test.suite.collector;

import au.net.netstorm.boost.test.aggregator.DefaultTestAggregator;
import au.net.netstorm.boost.test.aggregator.TestAggregator;
import au.net.netstorm.boost.test.automock.BoooostTestCase;
import junit.framework.Test;

public class AtomicTestSuite extends BoooostTestCase {
    private static final Class CLASS_IN_TEST_TREE = AtomicTestSuite.class;
    private static final TestAggregator AGGREGATOR = new DefaultTestAggregator(CLASS_IN_TEST_TREE);

    public static Test suite() {
        return AGGREGATOR.aggregate("Atomic", ".*AtomicTest");
    }
}
