package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.lifecycle.ThreadTestLifecycle;

public interface TestEngine {
    void runTest(LifecycleTest test, ThreadTestLifecycle lifecycle, String methodName);

    Throwable error(LifecycleTest test, Throwable t);// OK GenericIllegalRegexp {

    void tryCleanup(ThreadTestLifecycle lifecycle);
}
