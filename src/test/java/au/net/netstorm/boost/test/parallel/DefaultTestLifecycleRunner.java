package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.test.automock.NothingTestUberLifecycle;
import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.lifecycle.TestUberLifecycle;

public class DefaultTestLifecycleRunner implements TestLifecycleRunner {
    private final TestExceptionHandler handler = new DefaultTestExceptionHandler();

    public void run(LifecycleTest test) throws Throwable {
        TestUberLifecycle lifecycle = new NothingTestUberLifecycle();
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
        Runnable runnable = new DefaultRunnableTest(test);
        runnable.run();
        lifecycle.post();
    }
}
