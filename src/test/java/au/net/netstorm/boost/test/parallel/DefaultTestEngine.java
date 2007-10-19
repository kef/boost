package au.net.netstorm.boost.test.parallel;

import java.io.PrintStream;
import au.net.netstorm.boost.test.exception.ThrowableSupport;
import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.lifecycle.TestLifecycle;
import au.net.netstorm.boost.test.reflect.util.DefaultMethodTestUtil;
import au.net.netstorm.boost.test.reflect.util.MethodTestUtil;
import au.net.netstorm.boost.test.timing.DefaultTimer;
import au.net.netstorm.boost.test.timing.Timer;

public class DefaultTestEngine implements TestEngine {
    private static final Object[] NO_PARAMETERS = {};
    private final MethodTestUtil util = new DefaultMethodTestUtil();
    private final Timer timer = new DefaultTimer();

    public void run(LifecycleTest test, TestLifecycle lifecycle, String methodName) {
        boolean successful = false;
        try {
            runTest(test, lifecycle, methodName);
            successful = true;
        } catch (Throwable t) {
            successful = false;
            error(test, t);
        } finally {
            tryCleanup(lifecycle, successful);
        }
    }

    private void runTest(LifecycleTest test, TestLifecycle lifecycle, String methodName) {
        lifecycle.pre();
        timer.startClock();
        util.invoke(test, methodName, NO_PARAMETERS);
        timer.stopClock(test);
        lifecycle.post();
    }

    private void error(LifecycleTest test, Throwable t) {
        ThrowableSupport throwableSupport = test.throwableSupport();
        Throwable throwable = throwableSupport.translate(t);
        // FIX 2000 Is this how we want to handle throwable?
        throw new IllegalStateException(throwable);
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
