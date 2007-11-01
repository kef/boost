package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.lifecycle.TestThreadLifecycle;

public interface TestEngine {
    void runTest(LifecycleTest test, TestThreadLifecycle threadLifecycle);

    Throwable error(LifecycleTest test, Throwable t);// OK GenericIllegalRegexp {

    void tryCleanup(TestThreadLifecycle threadLifecycle);
}
