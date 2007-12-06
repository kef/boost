package au.net.netstorm.boost.test.suite.collector;

import junit.framework.Test;

public interface TestSuiteMaster {
    Test suite(Class suiteCls, Object... args);
}
