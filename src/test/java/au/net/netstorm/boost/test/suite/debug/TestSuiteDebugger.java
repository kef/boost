package au.net.netstorm.boost.test.suite.debug;

import junit.framework.Test;
import junit.framework.TestResult;
import junit.framework.TestSuite;

public class TestSuiteDebugger {
    public static void runSuite(Test test) {
        TestSuite suite = new TestSuite();
        suite.addTest(test);
        TestResult result = new TestResult();
        trySuiteRun(suite, result);
    }

    private static void trySuiteRun(TestSuite suite, TestResult result) {
        try {
            suite.run(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
