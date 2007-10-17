package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.test.lifecycle.LifecycleTest;

// FIX 2000 Use or Lose.
public interface ParallelRunner {
    void run(LifecycleTest test, int threads) throws Throwable;
}
