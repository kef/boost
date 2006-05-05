package au.net.netstorm.boost.test.suite;

import au.net.netstorm.boost.test.aggregator.TestAggregator;
import au.net.netstorm.boost.test.primordial.PrimordialTestCase;
import junit.framework.Test;

public class AcceptanceTestSuite extends PrimordialTestCase {
    // FIXME: SC043 Fieldise all new TestAggregator instances.
    public static Test suite() {
        return new TestAggregator().aggregate("Acceptance", ".*AcceptanceTest");
    }
}
