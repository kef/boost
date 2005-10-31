package au.net.netstorm.boost.testing.suite;

import au.net.netstorm.boost.testing.aggregator.TestSuiteAggregator;
import au.net.netstorm.boost.primordial.PrimordialTestCase;
import junit.framework.Test;

// FIXME: SC502 Move all testing.suite to "suite".
public class AtomicTestSuite extends PrimordialTestCase {
    public static Test suite() {
        return TestSuiteAggregator.aggregate("Atomic", ".*AtomicTest");
    }
}
