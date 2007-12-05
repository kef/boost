package au.net.netstorm.boost.test.suite.collector;

import java.io.File;
import au.net.netstorm.boost.test.core.BoooostCase;
import junit.framework.Test;

public class AtomicTestSuite extends BoooostCase {
    private static final AggregateTestSuiteHelper HELPER = new DefaultAggregateTestSuiteHelper("Atomic", AtomicTestSuite.class);

    // FIX (Dec 4, 2007) CORE SPLIT 87471 This looks like dupe with DemoTestSuite.
    public static Test suite(File root) {
        return HELPER.suite(root);
    }

    public static Test suite() {
        return HELPER.suite();
    }
}
