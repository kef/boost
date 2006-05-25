package au.net.netstorm.boost.test.suite.debug;

import au.net.netstorm.boost.test.suite.collector.AtomicTestSuite;

class AtomicTestSuiteDebugger {
    public static void main(String[] args) {
        TestSuiteDebugger.runSuite(AtomicTestSuite.suite());
    }
}
