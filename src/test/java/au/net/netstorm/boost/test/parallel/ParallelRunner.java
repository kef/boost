package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.lifecycle.TestLifecycle;

// FIX 2000 Use or Lose.
public interface ParallelRunner {
    void run(LifecycleTest test, int threads, TestLifecycle lifecycle) throws Throwable;
}
