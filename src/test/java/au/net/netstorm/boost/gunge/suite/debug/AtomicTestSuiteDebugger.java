package au.net.netstorm.boost.gunge.suite.debug;

import au.net.netstorm.boost.gunge.suite.collector.AtomicTestSuite;

class AtomicTestSuiteDebugger {
    public static void main(String[] args) {
        TestSuiteDebugger.runSuite(AtomicTestSuite.suite());
    }
}
