package au.net.netstorm.boost.test.lifecycle;

import java.io.PrintStream;
import au.net.netstorm.boost.test.exception.ThrowableSupport;

public final class DefaultLifecycleTestRunner implements LifecycleTestRunner {
    private final LifecycleTest testCase;

    public DefaultLifecycleTestRunner(LifecycleTest testCase) {
        this.testCase = testCase;
    }

    public void run() throws Throwable {
        TestLifecycle lifecycle = testCase.testLifecycle();
        ThrowableSupport throwableSupport = testCase.throwableSupport();
        boolean successful = true;
        try {
            run(lifecycle);
        }
        catch (Throwable t) {
            successful = false;
            throw throwableSupport.translate(t);
        }
        finally {
            cleanup(lifecycle, successful);
        }
    }

    private void run(TestLifecycle lifecycle) throws Throwable {
        lifecycle.pre();
        testCase.runTest();
        lifecycle.post();
    }

    private void cleanup(TestLifecycle lifecycle, boolean successful) {
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
