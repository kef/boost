package au.net.netstorm.boost.sniper.suite.debug;

import au.net.netstorm.boost.sniper.suite.collector.AtomicTestSuite;

class AtomicTestSuiteDebugger {
    public static void main(String[] args) {
        TestSuiteDebugger.runSuite(AtomicTestSuite.suite());
    }
}
