package au.net.netstorm.boost.test.suite.collector;

import au.net.netstorm.boost.test.core.BoooostCase;
import junit.framework.Test;
import junit.framework.TestSuite;

import java.io.File;

public class AllTestSuite extends BoooostCase {
    public static Test suite() {
        TestSuite suite = nuSuite();
        suite.addTest(AtomicTestSuite.suite());
        suite.addTest(DemoTestSuite.suite());
        return suite;
    }

    public static Test suite(File root) {
        TestSuite suite = nuSuite();
        suite.addTest(AtomicTestSuite.suite(root));
        suite.addTest(DemoTestSuite.suite(root));
        return suite;
    }

    private static TestSuite nuSuite() {
        return new TestSuite("The Whole Box and Dice");
    }
}
