package au.net.netstorm.boost.test.lifecycle;

import java.io.PrintStream;
import au.net.netstorm.boost.test.exception.ThrowableSupport;
import au.net.netstorm.boost.test.timing.DefaultTimedTestRunner;
import au.net.netstorm.boost.test.timing.TimedTestRunner;

public final class DefaultLifecycleTestRunner implements LifecycleTestRunner {
    private final TimedTestRunner runner = new DefaultTimedTestRunner();
    private final LifecycleTest testCase;
    private ThrowableSupport throwableSupport;
    private TestLifecycle lifecycle;

    public DefaultLifecycleTestRunner(LifecycleTest testCase) {
        this.testCase = testCase;
    }

    public void run() throws Throwable {
        init();
        runit();
    }

    private void init() {
        lifecycle = testCase.testLifecycle();
        throwableSupport = testCase.throwableSupport();
    }

    private void runit() throws Throwable {
        boolean successful = true;
        try {
            runner.run(testCase);
        }
        catch (Throwable t) {
            successful = false;
            throw throwableSupport.translate(t);
        }
        finally {
            cleanup(successful);
        }
    }

    private void cleanup(boolean successful) {
        tryCleanup(lifecycle, successful);
    }

    // OK GenericIllegalRegexp {
    private void tryCleanup(TestLifecycle lifecycle, boolean successful) {
        try {
            lifecycle.cleanup(successful);
        } catch (Throwable t) {
            PrintStream err = System.err;
            err.print("Oopsy daisy, we've alreay barfed ... ");
            t.printStackTrace(err);
        }
    }
    // } OK GenericIllegalRegexp
}
