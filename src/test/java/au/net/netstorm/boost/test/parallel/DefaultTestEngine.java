package au.net.netstorm.boost.test.parallel;

import java.io.PrintStream;
import au.net.netstorm.boost.test.exception.ThrowableSupport;
import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.lifecycle.TestLifecycle;
import au.net.netstorm.boost.test.reflect.util.DefaultMethodTestUtil;
import au.net.netstorm.boost.test.reflect.util.MethodTestUtil;

public class DefaultTestEngine implements TestEngine {
    private static final Object[] NO_PARAMETERS = {};
    private final MethodTestUtil util = new DefaultMethodTestUtil();
    private boolean successful = false;

    public void runTest(LifecycleTest test, TestLifecycle lifecycle) {
        pre(lifecycle);
        run(test);
        post(lifecycle);
        successful = true;
    }

    private void pre(TestLifecycle lifecycle) {
        lifecycle.pre();
    }

    public Throwable error(LifecycleTest test, Throwable t) {
        ThrowableSupport throwableSupport = test.throwableSupport();
        return throwableSupport.translate(t);
    }

    private void run(LifecycleTest test) {
        String methodName = test.getName();
        util.invoke(test, methodName, NO_PARAMETERS);
    }

    private void post(TestLifecycle lifecycle) {
        lifecycle.post();
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
