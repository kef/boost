package au.net.netstorm.boost.test.suite.collector;

import java.io.File;
import au.net.netstorm.boost.test.core.BoooostCase;
import junit.framework.Test;

// FIX (Dec 5, 2007) CORE SPLIT 87471 Is there any way to clean this up?
public class AllTestSuite extends BoooostCase {
    private static final TestSuiteBuilder BUILDER = new DefaultTestSuiteBuilder("The Whole Box and Dice", AtomicTestSuite.class, DemoTestSuite.class);

    public static Test suite() {
        return BUILDER.suite();
    }

    public static Test suite(File root) {
        return BUILDER.suite(root);
    }
}
