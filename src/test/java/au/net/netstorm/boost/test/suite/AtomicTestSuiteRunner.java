package au.net.netstorm.boost.test.suite;

// FIXME: SC506 Does this make sense.  See comment for TestSuiteRunnerUtil
class AtomicTestSuiteRunner {
    public static void main(String[] args) {
        TestSuiteRunnerUtil.runSuite(AtomicTestSuite.suite());
    }
}
