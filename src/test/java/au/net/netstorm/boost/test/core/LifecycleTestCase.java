package au.net.netstorm.boost.test.core;

import au.net.netstorm.boost.test.exception.DefaultThrowableSupport;
import au.net.netstorm.boost.test.exception.ThrowableSupport;
import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.parallel.DefaultTestRunner;
import au.net.netstorm.boost.test.parallel.DefaultThreadSupport;
import au.net.netstorm.boost.test.parallel.TestRunner;
import au.net.netstorm.boost.test.parallel.ThreadSupport;
import au.net.netstorm.boost.test.timing.DefaultTimingSupport;
import au.net.netstorm.boost.test.timing.TimingSupport;

public abstract class LifecycleTestCase extends CleanTestCase implements LifecycleTest {
    private final TestRunner runner = new DefaultTestRunner();

    public final void runBare() throws Throwable {
        runner.run(this);
    }

    public ThrowableSupport throwableSupport() {
        return new DefaultThrowableSupport();
    }

    public TimingSupport timingSupport() {
        return new DefaultTimingSupport();
    }

    public ThreadSupport threadSupport() {
        return new DefaultThreadSupport();
    }
}
