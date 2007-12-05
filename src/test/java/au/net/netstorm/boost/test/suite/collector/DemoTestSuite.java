package au.net.netstorm.boost.test.suite.collector;

import java.io.File;
import au.net.netstorm.boost.test.core.BoooostCase;
import junit.framework.Test;

// FIX SC600 Rename "build" area to "gen".
public class DemoTestSuite extends BoooostCase {
    private static final AggregateTestSuiteHelper HELPER = new DefaultAggregateTestSuiteHelper("Demo", DemoTestSuite.class);

    public static Test suite() {
        return HELPER.suite();
    }

    public static Test suite(File root) {
        return HELPER.suite(root);
    }
}
