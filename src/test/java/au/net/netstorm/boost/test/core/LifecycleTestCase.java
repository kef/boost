package au.net.netstorm.boost.test.core;

import au.net.netstorm.boost.test.exception.DefaultThrowableSupport;
import au.net.netstorm.boost.test.exception.ThrowableSupport;
import au.net.netstorm.boost.test.lifecycle.DefaultLifecycleTestRunner;
import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.lifecycle.LifecycleTestRunner;

public abstract class LifecycleTestCase extends CleanTestCase implements LifecycleTest {
    private final LifecycleTestRunner runner;

    public LifecycleTestCase() {
        runner = new DefaultLifecycleTestRunner(this);
    }

    public final void runBare() throws Throwable {
        runner.run();
    }

    public ThrowableSupport throwableSupport() {
        return new DefaultThrowableSupport();
    }
}
