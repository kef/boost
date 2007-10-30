package au.net.netstorm.boost.test.parallel;

import java.io.PrintStream;
import au.net.netstorm.boost.test.exception.ThrowableSupport;
import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.lifecycle.TestThreadLifecycle;
import au.net.netstorm.boost.test.reflect.util.DefaultMethodTestUtil;
import au.net.netstorm.boost.test.reflect.util.MethodTestUtil;
import au.net.netstorm.boost.test.timing.DefaultTimer;
import au.net.netstorm.boost.test.timing.Timer;

public class DefaultTestEngine implements TestEngine {
    private static final Object[] NO_PARAMETERS = {};
    private final MethodTestUtil util = new DefaultMethodTestUtil();
    private final Timer timer = new DefaultTimer();
    private boolean successful = false;

    public void runTest(LifecycleTest test, TestThreadLifecycle threadLifecycle, String methodName) {
        pre(threadLifecycle);
        run(test, methodName);
        post(test, threadLifecycle, methodName);
        successful = true;
    }

    private void pre(TestThreadLifecycle threadLifecycle) {
        threadLifecycle.pre();
        timer.startClock();
    }

    public Throwable error(LifecycleTest test, Throwable t) {
        ThrowableSupport throwableSupport = test.throwableSupport();
        return throwableSupport.translate(t);
    }

    private void run(LifecycleTest test, String methodName) {
        util.invoke(test, methodName, NO_PARAMETERS);
    }

    private void post(LifecycleTest test, TestThreadLifecycle threadLifecycle, String methodName) {
        timer.stopClock(test, methodName);
        threadLifecycle.post();
    }

    // OK GenericIllegalRegexp {
    public void tryCleanup(TestThreadLifecycle threadLifecycle) {
        try {
            threadLifecycle.cleanup(successful);
        } catch (Throwable t) {
            PrintStream err = System.err;
            err.print("Oopsy daisy, we've barfed during test lifecycle cleanup... ");
            t.printStackTrace(err);
        }
    }
    // } OK GenericIllegalRegexp
}
