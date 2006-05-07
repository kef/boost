package au.net.netstorm.boost.test.suite;

import au.net.netstorm.boost.test.aggregator.DefaultTestAggregator;
import au.net.netstorm.boost.test.primordial.PrimordialTestCase;
import junit.framework.Test;

public class AcceptanceTestSuite extends PrimordialTestCase {
    // FIXME: SC043 Fieldise all new TestAggregator instances.
    public static Test suite() {
        return new DefaultTestAggregator().aggregate("Acceptance", ".*AcceptanceTest");
    }
}
