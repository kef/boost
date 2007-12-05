package au.net.netstorm.boost.test.suite.collector;

import java.io.File;
import junit.framework.TestSuite;

public interface TestSuiteBuilder {
    TestSuite suite();

    TestSuite suite(File root);
}
