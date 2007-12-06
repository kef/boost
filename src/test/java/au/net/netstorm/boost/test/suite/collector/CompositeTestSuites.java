package au.net.netstorm.boost.test.suite.collector;

import au.net.netstorm.boost.test.reflect.util.DefaultMethodTestUtil;
import au.net.netstorm.boost.test.reflect.util.MethodTestUtil;
import junit.framework.Test;
import junit.framework.TestSuite;

import java.io.File;

public class CompositeTestSuites implements TestSuites {
    private static final Object[] NO_ARGS = {};
    TestSuiteMaster suitor = new DefaultTestSuiteMaster();
    MethodTestUtil methoder = new DefaultMethodTestUtil();
    private final Class[] suites;
    private final String name;


    // FIX (Dec 6, 2007) CORE SPLIT 87471 Genericise.
    public CompositeTestSuites(String name, Class... suites) {
        this.name = name;
        this.suites = suites;
    }

    public TestSuite suite() {
        TestSuite result = new TestSuite(name);
        for (Class suite : suites) suite(result, suite);
        return result;
    }

    public TestSuite suite(File root) {
        TestSuite result = new TestSuite(name);
        for (Class cls : suites) suite(result, cls, root);
        return result;
    }

    private void suite(TestSuite suite, Class suiteCls) {
        Test test = (Test) methoder.invoke(suiteCls, "suite", NO_ARGS);
        suite.addTest(test);
    }

    private <T extends BoostSuite> void suite(TestSuite result, Class<T> suiteCls, File root) {
        TestSuites suites = suitor.suite(suiteCls);
        Test test = suites.suite(root);
        result.addTest(test);
    }
}
