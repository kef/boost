package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.lifecycle.TestLifecycle;

public interface BasicRunner {
    void run(LifecycleTest test, TestLifecycle lifecycle) throws Throwable;
}
