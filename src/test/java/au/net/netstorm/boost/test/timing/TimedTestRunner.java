package au.net.netstorm.boost.test.timing;

import au.net.netstorm.boost.test.lifecycle.LifecycleTest;

// FIX 2000 Re-package?
public interface TimedTestRunner {
    void run(LifecycleTest test) throws Throwable;
}
