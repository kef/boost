package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.lifecycle.TestLifecycle;
import au.net.netstorm.boost.test.timing.DefaultTimer;
import au.net.netstorm.boost.test.timing.Timer;

// FIX 2000 Delete me.
public class DefaultBasicRunner implements BasicRunner {
    private final Timer timer = new DefaultTimer();

    // FIX 2000 Clean up.
    public void run(LifecycleTest test, TestLifecycle lifecycle) throws Throwable {
        lifecycle.pre();
        timer.startClock();
        test.runTest();
        String methodName = test.getName();
        timer.stopClock(test, methodName);
        lifecycle.post();
    }
}
