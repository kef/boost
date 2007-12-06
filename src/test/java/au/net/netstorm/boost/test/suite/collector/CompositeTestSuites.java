package au.net.netstorm.boost.test.suite.collector;

import junit.framework.Test;
import junit.framework.TestSuite;

import java.io.File;

public class CompositeTestSuites implements TestSuites {
    private final Class[] suites;
    private final String name;
    TestSuiteMaster suitor = new DefaultTestSuiteMaster();

    // FIX (Dec 6, 2007)   87471 Class<T extends BoostTests>
    public CompositeTestSuites(String name, Class... suites) {
        this.name = name;
        this.suites = suites;
    }

    public TestSuite suite() {
        return doSuite();
    }

    public TestSuite suite(File root) {
        return doSuite(root);
    }

    private TestSuite doSuite(Object... args) {
        TestSuite result = new TestSuite(name);
        for (Class cls : suites) addSuite(result, cls, args);
        return result;
    }

    private void addSuite(TestSuite result, Class suiteCls, Object... args) {
        Test suite = suitor.suite(suiteCls, args);
        result.addTest(suite);
    }
}
