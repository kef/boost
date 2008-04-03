package au.net.netstorm.boost.gunge.suite.collector;

import java.io.File;
import junit.framework.Test;

public interface TestSuites {
    Test suite();

    Test suite(String name, File root);
}
