package au.net.netstorm.boost.test.suite;

import au.net.netstorm.boost.test.aggregator.TestAggregator;
import au.net.netstorm.boost.test.primordial.PrimordialTestCase;
import junit.framework.Test;

public class IntegrationTestSuite extends PrimordialTestCase {
    public static Test suite() {
        return new TestAggregator().aggregate("Integration", ".*IntegrationTest");
    }
}
