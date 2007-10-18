package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.lifecycle.TestLifecycle;
import au.net.netstorm.boost.test.timing.DefaultTimer;
import au.net.netstorm.boost.test.timing.Timer;

public class DefaultBasicRunner implements BasicRunner {
    private final Timer timer = new DefaultTimer();

    public void run(LifecycleTest test, TestLifecycle lifecycle) throws Throwable {
        lifecycle.pre();
        timer.startClock();
        test.runTest();
        timer.stopClock(test);
        lifecycle.post();
    }
}
