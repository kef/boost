package au.net.netstorm.boost.test.suite.collector;

import junit.framework.TestSuite;

import java.io.File;

public interface TestSuiteBuilder {
    TestSuite suite();

    TestSuite suite(File root);
}
