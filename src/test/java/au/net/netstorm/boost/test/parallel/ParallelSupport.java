package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.test.lifecycle.LifecycleTest;

public interface ParallelSupport {
    void single(LifecycleTest test) throws Throwable;

    void multi(LifecycleTest test) throws Throwable;
}
