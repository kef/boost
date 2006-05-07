package au.net.netstorm.boost.test.suite.util;

import au.net.netstorm.boost.test.suite.AtomicTestSuite;

class AtomicTestSuiteRunner {
    public static void main(String[] args) {
        TestSuiteRunnerUtil.runSuite(AtomicTestSuite.suite());
    }
}
