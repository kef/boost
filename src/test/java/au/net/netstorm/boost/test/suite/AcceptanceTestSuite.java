package au.net.netstorm.boost.test.suite;

import au.net.netstorm.boost.test.aggregator.DefaultTestAggregator;
import au.net.netstorm.boost.test.aggregator.TestAggregator;
import au.net.netstorm.boost.test.primordial.PrimordialTestCase;
import junit.framework.Test;

public class AcceptanceTestSuite extends PrimordialTestCase {
    // FIXME: SC043 Fieldise all new TestAggregator instances.
    private static final TestAggregator AGGREGATOR = new DefaultTestAggregator();

    public static Test suite() {
        return AGGREGATOR.aggregate("Acceptance", ".*AcceptanceTest");
    }
}
