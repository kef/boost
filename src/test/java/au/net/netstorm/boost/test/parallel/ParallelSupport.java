package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.lifecycle.TestLifecycle;

public interface ParallelSupport {
    void single(LifecycleTest test, TestLifecycle lifecycle) throws Throwable;

    void multi(LifecycleTest test) throws Throwable;
}
