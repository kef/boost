package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.test.lifecycle.LifecycleTest;

public interface ThreadSupport {
    void single(LifecycleTest test) throws Throwable;

    void multi(LifecycleTest test) throws Throwable;
}
