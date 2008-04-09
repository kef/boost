package au.net.netstorm.boost.sniper.suite.collector;

import junit.framework.Test;

// FIX SC600 Rename "build" area to "gen".
public class DemoTestSuite implements BoostSuite {
    private static final TestSuites DEMO = new FileBasedTestSuites("Demo", DemoTestSuite.class);

    public static Test suite() {
        return DEMO.suite();
    }

    public TestSuites suites() {
        return DEMO;
    }
}
