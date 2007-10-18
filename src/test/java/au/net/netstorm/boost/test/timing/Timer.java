package au.net.netstorm.boost.test.timing;

import au.net.netstorm.boost.test.lifecycle.LifecycleTest;

public interface Timer {
    void startClock();

    // FIX 2000 Move stop/start clock stuff out of here.
    void stopClock(LifecycleTest test);
}
