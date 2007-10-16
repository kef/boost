package au.net.netstorm.boost.test.core;

import au.net.netstorm.boost.test.exception.DefaultThrowableSupport;
import au.net.netstorm.boost.test.exception.ThrowableSupport;
import au.net.netstorm.boost.test.lifecycle.DefaultLifecycleTestRunner;
import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.lifecycle.LifecycleTestRunner;
import au.net.netstorm.boost.test.parallel.DefaultParallelSupport;
import au.net.netstorm.boost.test.parallel.ParallelSupport;
import au.net.netstorm.boost.test.timing.DefaultTimingSupport;
import au.net.netstorm.boost.test.timing.TimingSupport;

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

    public TimingSupport timingSupport() {
        return new DefaultTimingSupport();
    }

    public ParallelSupport parallelSupport() {
        return new DefaultParallelSupport();
    }
}
