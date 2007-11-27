package au.net.netstorm.boost.test.parallel;

import java.io.PrintStream;
import au.net.netstorm.boost.test.exception.ThrowableSupport;
import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.lifecycle.TestLifecycle;

public class DefaultTestLifecycleRunner implements TestLifecycleRunner {

    public void run(LifecycleTest test) throws Throwable {
        TestLifecycle lifecycle = test.lifecycle();
        boolean successful = false;
        try {
            runTest(test, lifecycle);
            successful = true;
        } catch (Throwable t) {
            ThrowableSupport throwableSupport = test.throwableSupport();
            throw throwableSupport.translate(t);
        } finally {
            tryCleanup(lifecycle, successful);
        }
    }

    public void runTest(LifecycleTest test, TestLifecycle lifecycle) throws Throwable {
        lifecycle.pre();
        test.runTest();
        lifecycle.post();
    }

    // OK GenericIllegalRegexp {
    public void tryCleanup(TestLifecycle lifecycle, boolean successful) {
        try {
            lifecycle.cleanup(successful);
        } catch (Throwable t) {
            PrintStream err = System.err;
            err.print("Oopsy daisy, we've barfed during test lifecycle cleanup... ");
            t.printStackTrace(err);
        }
    }
    // } OK GenericIllegalRegexp
}
