package au.net.netstorm.boost.test.suite.collector;

import java.io.File;
import junit.framework.Test;

public interface AggregateTestSuiteHelper {
    Test suite(File root);

    Test suite();
}
