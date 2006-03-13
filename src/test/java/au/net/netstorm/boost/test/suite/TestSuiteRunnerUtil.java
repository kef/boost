package au.net.netstorm.boost.test.suite;

import junit.framework.Test;
import junit.framework.TestResult;
import junit.framework.TestSuite;

class TestSuiteRunnerUtil {
    public static void runSuite(Test suiteTests) {
        TestSuite suite = new TestSuite();
        suite.addTest(suiteTests);
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
