package au.net.netstorm.boost.test.suite.collector;

import junit.framework.Test;

import java.io.File;

public interface TestSuites {
    Test suite();

    Test suite(String name, File root);
}
