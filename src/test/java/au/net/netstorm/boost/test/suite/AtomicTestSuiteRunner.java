package au.net.netstorm.boost.test.suite;

// FIXME: SC043 Does this make sense.  See comment for TestSuiteRunnerUtil

class AtomicTestSuiteRunner {
    public static void main(String[] args) {
        TestSuiteRunnerUtil.runSuite(AtomicTestSuite.suite());
    }
}
