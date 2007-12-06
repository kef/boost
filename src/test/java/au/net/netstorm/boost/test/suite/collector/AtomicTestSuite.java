package au.net.netstorm.boost.test.suite.collector;

import junit.framework.Test;

public class AtomicTestSuite implements BoostSuite {
    private static final TestSuites ATOMIC = new FileBasedTestSuites("Atomic", AtomicTestSuite.class);

    public static Test suite() {
        return ATOMIC.suite();
    }

    public TestSuites suites() {
        return ATOMIC;
    }
}
