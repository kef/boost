package au.net.netstorm.boost.test.suite.collector;

import junit.framework.Test;

import java.io.File;

// FIX (Dec 6, 2007)   87471 Remove dupe.  See TestSuiteBuilder.
public interface AggregateTestSuiteHelper {
    Test suite();

    Test suite(File root);
}
