package au.net.netstorm.boost.test.suite.collector;

import au.net.netstorm.boost.test.core.BoooostCase;
import junit.framework.Test;

import java.io.File;

// FIX SC600 Rename "build" area to "gen".
public class DemoTestSuite extends BoooostCase {
    private static final TestSuiteHelper HELPER = new DefaultTestSuiteHelper("Demo", DemoTestSuite.class);

    public static Test suite() {
        return HELPER.suite();
    }

    public static Test suite(File root) {
        return HELPER.suite(root);
    }
}
