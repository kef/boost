package au.net.netstorm.boost.test.suite.collector;

import au.net.netstorm.boost.test.reflect.util.DefaultMethodTestUtil;
import au.net.netstorm.boost.test.reflect.util.MethodTestUtil;
import junit.framework.Test;
import junit.framework.TestSuite;

import java.io.File;

public class DefaultTestSuiteBuilder implements TestSuiteBuilder {
    private final Class[] suites;
    private final String name;
    MethodTestUtil methoder = new DefaultMethodTestUtil();

    // FIX (Dec 6, 2007)   87471 Class<T extends BoostTests>
    public DefaultTestSuiteBuilder(String name, Class... suites) {
        this.name = name;
        this.suites = suites;
    }

    public TestSuite suite() {
        return doSuite();
    }

    public TestSuite suite(File root) {
        Object[] args = {root};
        return doSuite(args);
    }

    private TestSuite doSuite(Object... args) {
        TestSuite result = new TestSuite(name);
        for (Class cls : suites) addSuite(result, cls, args);
        return result;
    }

    private void addSuite(TestSuite result, Class suiteCls, Object... args) {
        Test suite = suite(suiteCls, args);
        result.addTest(suite);
    }

    private Test suite(Class suiteCls, Object... args) {
        return (Test) methoder.invoke(suiteCls, "suite", args);
    }
}
