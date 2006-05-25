package au.net.netstorm.boost.test.suite.debug;

import au.net.netstorm.boost.test.suite.collector.AtomicTestSuite;

// FIXME: SC043 Rename to "debugger" ?
class AtomicTestSuiteRunner {
    public static void main(String[] args) {
        TestSuiteRunnerUtil.runSuite(AtomicTestSuite.suite());
    }
}
