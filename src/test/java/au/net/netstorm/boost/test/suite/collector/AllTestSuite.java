package au.net.netstorm.boost.test.suite.collector;

import au.net.netstorm.boost.test.core.BoooostCase;
import junit.framework.Test;

import java.io.File;

public class AllTestSuite extends BoooostCase {
    private static final TestSuites COMPOSITES = new CompositeTestSuites("The Whole Box and Dice", AtomicTestSuite.class, DemoTestSuite.class);

    public static Test suite() {
        return COMPOSITES.suite();
    }

    public static Test suite(File root) {
        return COMPOSITES.suite(root);
    }
}
