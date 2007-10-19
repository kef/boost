package au.net.netstorm.boost.test.lifecycle;

import au.net.netstorm.boost.test.timing.DefaultTimedTestRunner;
import au.net.netstorm.boost.test.timing.TimedTestRunner;

public final class DefaultLifecycleTestRunner implements LifecycleTestRunner {
    private final TimedTestRunner runner = new DefaultTimedTestRunner();
    private final LifecycleTest testCase;

    public DefaultLifecycleTestRunner(LifecycleTest testCase) {
        this.testCase = testCase;
    }

    public void run() throws Throwable {
        runit();
    }

    private void runit() throws Throwable {
        runner.run(testCase);
    }
}
