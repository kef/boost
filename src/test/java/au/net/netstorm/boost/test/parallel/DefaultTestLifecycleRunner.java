package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.test.lifecycle.LifecycleTest;

public class DefaultTestLifecycleRunner implements TestLifecycleRunner {
    private final TestExceptionHandler handler = new DefaultTestExceptionHandler();

    public void run(LifecycleTest test) throws Throwable {
        Runnable runnable = new DefaultRunnableTest(test);
        runnable.run();
        handler.checkExceptions();
    }
}
