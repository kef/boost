package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.lifecycle.TestUberLifecycle;

public class DefaultTestLifecycleRunner implements TestLifecycleRunner {
    private final TestExceptionHandler handler = new DefaultTestExceptionHandler();
    private final TestThreadEngine engine = new DefaultTestThreadEngine();

    public void run(LifecycleTest test) throws Throwable {
        TestUberLifecycle lifecycle = test.uberLifecycle();
        boolean successful = false;
        try {
            doExecute(test, lifecycle);
            handler.checkExceptions();
            successful = true;
        } finally {
            lifecycle.cleanup(successful);
        }
    }

    private void doExecute(LifecycleTest test, TestUberLifecycle lifecycle) {
        lifecycle.pre();
        engine.start(test);
        lifecycle.post();
    }
}
