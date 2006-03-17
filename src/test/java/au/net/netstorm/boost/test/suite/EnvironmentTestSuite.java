package au.net.netstorm.boost.test.suite;

import au.net.netstorm.boost.test.aggregator.TestSuiteAggregator;
import au.net.netstorm.boost.test.primordial.PrimordialTestCase;
import junit.framework.Test;

public class EnvironmentTestSuite extends PrimordialTestCase {
    public static Test suite() {
        return TestSuiteAggregator.aggregate("Environment", ".*EnvironmentTest");
    }
}
