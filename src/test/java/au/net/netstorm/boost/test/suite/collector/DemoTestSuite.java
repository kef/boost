package au.net.netstorm.boost.test.suite.collector;

import junit.framework.Test;

// FIX SC600 Rename "build" area to "gen".
public class DemoTestSuite implements BoostSuite {
    private static final TestSuites SUITES = new FileBasedTestSuites("Demo", DemoTestSuite.class);

    public static Test suite() {
        return SUITES.suite();
    }

    public TestSuites suites() {
        return SUITES;
    }
}
