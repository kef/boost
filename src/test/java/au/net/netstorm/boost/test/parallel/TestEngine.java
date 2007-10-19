package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.lifecycle.TestLifecycle;

public interface TestEngine {
    void run(LifecycleTest test, TestLifecycle lifecycle, String methodName);
}
