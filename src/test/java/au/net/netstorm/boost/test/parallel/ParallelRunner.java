package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.test.lifecycle.LifecycleTest;

public interface ParallelRunner {
    void run(LifecycleTest test, int threads) throws Throwable;
}
