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
    private boolean noExceptions = false;

    public void runTest(LifecycleTest test, TestLifecycle lifecycle, String methodName) {
        pre(lifecycle);
        run(test, methodName);
        post(test, lifecycle);
    }

    private void pre(TestLifecycle lifecycle) {
        lifecycle.pre();
        timer.startClock();
    }

    private void run(LifecycleTest test, String methodName) {
        util.invoke(test, methodName, NO_PARAMETERS);
    }

    private void post(LifecycleTest test, TestLifecycle lifecycle) {
        timer.stopClock(test);
        lifecycle.post();
        noExceptions = true;
    }

    public void error(LifecycleTest test, Throwable t) {
        ThrowableSupport throwableSupport = test.throwableSupport();
        Throwable throwable = throwableSupport.translate(t);
        // FIX 2000 Is this how we want to handle throwable?
        throw new IllegalStateException(throwable);
    }

    // OK GenericIllegalRegexp {
    public void tryCleanup(TestLifecycle lifecycle) {
        try {
            lifecycle.cleanup(noExceptions);
        } catch (Throwable t) {
            PrintStream err = System.err;
            err.print("Oopsy daisy, we've alreay barfed ... ");
            t.printStackTrace(err);
        }
    }
    // } OK GenericIllegalRegexp
}
