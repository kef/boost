package au.net.netstorm.boost.test.suite.util;

import junit.framework.Test;
import junit.framework.TestResult;
import junit.framework.TestSuite;

// FIXME: SC043 Does this make sense any more?  Vlad/James?
// FIXME: SC043 Move these into suite.util.

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
