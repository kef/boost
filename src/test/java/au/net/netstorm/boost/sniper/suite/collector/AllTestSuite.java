package au.net.netstorm.boost.sniper.suite.collector;

import junit.framework.Test;

public class AllTestSuite implements BoostSuite {
    private static final TestSuites COMPOSITES = new CompositeTestSuites(
            "The Whole Box and Dice",
            AtomicTestSuite.class,
            DemoTestSuite.class
    );

    public static Test suite() {
        return COMPOSITES.suite();
    }

    public TestSuites suites() {
        return COMPOSITES;
    }
}
