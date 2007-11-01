package au.net.netstorm.boost.test.parallel;

import java.io.PrintStream;
import au.net.netstorm.boost.test.exception.ThrowableSupport;
import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.lifecycle.TestThreadLifecycle;
import au.net.netstorm.boost.test.reflect.util.DefaultMethodTestUtil;
import au.net.netstorm.boost.test.reflect.util.MethodTestUtil;

public class DefaultTestEngine implements TestEngine {
    private static final Object[] NO_PARAMETERS = {};
    private final MethodTestUtil util = new DefaultMethodTestUtil();
    private boolean successful = false;

    public void runTest(LifecycleTest test, TestThreadLifecycle threadLifecycle) {
        pre(threadLifecycle);
        run(test);
        post(threadLifecycle);
        successful = true;
    }

    private void pre(TestThreadLifecycle threadLifecycle) {
        threadLifecycle.pre();
    }

    public Throwable error(LifecycleTest test, Throwable t) {
        ThrowableSupport throwableSupport = test.throwableSupport();
        return throwableSupport.translate(t);
    }

    private void run(LifecycleTest test) {
        String methodName = test.getName();
        util.invoke(test, methodName, NO_PARAMETERS);
    }

    private void post(TestThreadLifecycle threadLifecycle) {
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
