package au.net.netstorm.boost.test.suite.collector;

import au.net.netstorm.boost.test.reflect.util.DefaultMethodTestUtil;
import au.net.netstorm.boost.test.reflect.util.MethodTestUtil;
import junit.framework.TestSuite;

import java.io.File;

public class DefaultTestSuiteBuilder implements TestSuiteBuilder {
    private static final Object[] NO_ARGS = {};
    private final Class[] suites;
    private final String name;
    MethodTestUtil methoder = new DefaultMethodTestUtil();

    // FIX (Dec 6, 2007)   87471 Class<T extends BoostTests> 
    public DefaultTestSuiteBuilder(String name, Class... suites) {
        this.name = name;
        this.suites = suites;
    }

    public TestSuite suite() {
        return doSuite(NO_ARGS);
    }

    public TestSuite suite(File root) {
        Object[] args = {root};
        return doSuite(args);
    }

    private TestSuite doSuite(Object[] args) {
        TestSuite result = new TestSuite(name);
        for (Class cls : suites) addSuite(result, cls, args);
        return result;
    }

    private void addSuite(TestSuite result, Class suiteCls, Object[] args) {
        TestSuite suite = (TestSuite) methoder.invoke(suiteCls, "suite", args);
        result.addTest(suite);
    }
}
