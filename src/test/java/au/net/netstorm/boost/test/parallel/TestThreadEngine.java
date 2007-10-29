package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.test.lifecycle.LifecycleTest;

public interface TestThreadEngine {
    void start(LifecycleTest test);
}
