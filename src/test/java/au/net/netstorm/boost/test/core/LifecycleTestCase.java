package au.net.netstorm.boost.test.core;

import au.net.netstorm.boost.test.exception.DefaultThrowableSupport;
import au.net.netstorm.boost.test.exception.ThrowableSupport;
import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.parallel.DefaultTestLifecycleRunner;
import au.net.netstorm.boost.test.parallel.DefaultThreadCount;
import au.net.netstorm.boost.test.parallel.TestLifecycleRunner;
import au.net.netstorm.boost.test.parallel.ThreadCount;
import au.net.netstorm.boost.test.timing.DefaultTimingHandler;
import au.net.netstorm.boost.test.timing.TimingHandler;

public abstract class LifecycleTestCase extends CleanTestCase implements LifecycleTest {
    private final TestLifecycleRunner runner = new DefaultTestLifecycleRunner();

    public final void runBare() throws Throwable {
        runner.run(this);
    }

    public ThrowableSupport throwableSupport() {
        return new DefaultThrowableSupport();
    }

    public TimingHandler timingHandler() {
        return new DefaultTimingHandler();
    }

    public ThreadCount threadSupport() {
        return new DefaultThreadCount();
    }
}
