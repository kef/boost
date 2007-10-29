package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.test.lifecycle.LifecycleTest;

public interface TestThreadCreator {
    Thread[] create(LifecycleTest test);
}
