package au.net.netstorm.boost.test.suite.collector;

import junit.framework.Test;

import java.io.File;

public interface AggregateTestSuiteHelper {
    Test suite();

    Test suite(File root);
}
