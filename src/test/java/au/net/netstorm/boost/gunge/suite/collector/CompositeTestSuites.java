package au.net.netstorm.boost.gunge.suite.collector;

import java.io.File;
import au.net.netstorm.boost.gunge.reflect.util.DefaultMethodTestUtil;
import au.net.netstorm.boost.gunge.reflect.util.MethodTestUtil;
import junit.framework.Test;
import junit.framework.TestSuite;

public class CompositeTestSuites implements TestSuites {
    private static final Object[] NO_ARGS = {};
    TestSuiteMaster suitor = new DefaultTestSuiteMaster();
    MethodTestUtil methoder = new DefaultMethodTestUtil();
    private final Class[] suites;
    private final String name;

    public CompositeTestSuites(String name, Class... suites) {
        this.name = name;
        this.suites = suites;
    }

    public TestSuite suite() {
        TestSuite result = new TestSuite(name);
        for (Class suite : suites) suite(result, suite);
        return result;
    }

    public TestSuite suite(String name, File root) {
        TestSuite result = new TestSuite(name);
        for (Class cls : suites) suite(result, cls, root);
        return result;
    }

    private void suite(TestSuite suite, Class suiteCls) {
        Test test = (Test) methoder.invoke(suiteCls, "suite", NO_ARGS);
        suite.addTest(test);
    }

    private void suite(TestSuite result, Class suiteCls, File root) {
        TestSuites suites = suitor.suite(suiteCls);
        Test test = suites.suite(name, root);
        result.addTest(test);
    }
}
