package au.net.netstorm.boost.test.lifecycle;

import au.net.netstorm.boost.test.exception.ExceptionSupport;

public final class DefaultLifecycleTestRunner implements LifecycleTestRunner {
    private final LifecycleTestCase testCase;

    public DefaultLifecycleTestRunner(LifecycleTestCase testCase) {
        this.testCase = testCase;
    }

    public void run() throws Throwable {
        TestLifecycle lifecycle = testCase.testLifecycle();
        ExceptionSupport exceptionSupport = testCase.exceptionSupport();
        try {
            lifecycle.pre();
            testCase.runTest();
            lifecycle.post();
        }
        catch (RuntimeException e) {
            throw exceptionSupport.translate(e);
        }
        finally {
            lifecycle.cleanup();
        }
    }
}
