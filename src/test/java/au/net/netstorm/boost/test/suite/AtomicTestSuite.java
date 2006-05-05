package au.net.netstorm.boost.test.suite;

import au.net.netstorm.boost.test.aggregator.TestAggregator;
import au.net.netstorm.boost.test.primordial.PrimordialTestCase;
import junit.framework.Test;

// FIXME: SC502 Move all test.suite to "suite".

public class AtomicTestSuite extends PrimordialTestCase {
    public static Test suite() {
        return new TestAggregator().aggregate("Atomic", ".*AtomicTest");
    }
}
