package au.net.netstorm.boost.test.suite.collector;

import junit.framework.Test;

import java.io.File;

public interface TestSuiteHelper {
    Test suite(File root);

    Test suite();
}
