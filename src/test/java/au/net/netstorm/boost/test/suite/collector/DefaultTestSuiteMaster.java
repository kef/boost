package au.net.netstorm.boost.test.suite.collector;

import au.net.netstorm.boost.test.reflect.util.DefaultMethodTestUtil;
import au.net.netstorm.boost.test.reflect.util.MethodTestUtil;
import junit.framework.Test;

public class DefaultTestSuiteMaster implements TestSuiteMaster {
    MethodTestUtil methoder = new DefaultMethodTestUtil();

    public Test suite(Class suiteCls, Object... args) {
        return (Test) methoder.invoke(suiteCls, "suite", args);
    }
}
