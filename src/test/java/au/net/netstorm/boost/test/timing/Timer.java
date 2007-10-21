package au.net.netstorm.boost.test.timing;

import au.net.netstorm.boost.test.lifecycle.LifecycleTest;

public interface Timer {
    void startClock();

    void stopClock(LifecycleTest test, String methodName);
}
