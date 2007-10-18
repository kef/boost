package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.test.lifecycle.LifecycleTest;

public interface ParallelSupport {
    void run(LifecycleTest test) throws Throwable;
}
