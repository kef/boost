package au.net.netstorm.boost.test.suite.collector;

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

    // FIX (Dec 6, 2007) BREADCRUMB CORE SPLIT 87471 CCCCCCCCCCCCCCCCCC Introduce BoostSuite for this.
    // FIX (Dec 6, 2007) CORE SPLIT 87471 And do it everywhere.
    public TestSuites suites() {
        return COMPOSITES;
    }
}
