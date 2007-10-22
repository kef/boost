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
    private boolean successful = false;

    public void runTest(LifecycleTest test, TestLifecycle lifecycle, String methodName) {
        pre(lifecycle);
        run(test, methodName);
        post(test, lifecycle, methodName);
        successful = true;
    }

    private void pre(TestLifecycle lifecycle) {
        lifecycle.testPre();
        timer.startClock();
    }

    private void run(LifecycleTest test, String methodName) {
        util.invoke(test, methodName, NO_PARAMETERS);
    }

    private void post(LifecycleTest test, TestLifecycle lifecycle, String methodName) {
        timer.stopClock(test, methodName);
        lifecycle.testPost();
    }

    public Throwable error(LifecycleTest test, Throwable t) {
        ThrowableSupport throwableSupport = test.throwableSupport();
        return throwableSupport.translate(t);
    }

    // OK GenericIllegalRegexp {
    public void tryCleanup(TestLifecycle lifecycle) {
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
