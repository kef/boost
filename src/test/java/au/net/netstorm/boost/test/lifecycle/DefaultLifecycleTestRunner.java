package au.net.netstorm.boost.test.lifecycle;

import au.net.netstorm.boost.test.exception.ThrowableSupport;

public final class DefaultLifecycleTestRunner implements LifecycleTestRunner {
    private final LifecycleTest testCase;

    public DefaultLifecycleTestRunner(LifecycleTest testCase) {
        this.testCase = testCase;
    }

    public void run() throws Throwable {
        TestLifecycle lifecycle = testCase.testLifecycle();
        ThrowableSupport throwableSupport = testCase.throwableSupport();
        try {
            lifecycle.pre();
            testCase.runTest();
            lifecycle.post();
        }
        catch (Throwable t) {
            throw throwableSupport.translate(t);
        }
        finally {
            cleanup(lifecycle);
        }
    }

    private void cleanup(TestLifecycle lifecycle) {
        tryCleanup(lifecycle);
    }

    // OK GenericIllegalRegexp {
    private void tryCleanup(TestLifecycle lifecycle) {
        try {
            lifecycle.cleanup();
        } catch (Throwable t) {
            System.err.println("Oopsy daisy ");
        }
    }
    // } OK GenericIllegalRegexp
}
