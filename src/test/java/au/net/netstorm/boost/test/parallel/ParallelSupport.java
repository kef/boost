package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.test.lifecycle.LifecycleTest;

public interface ParallelSupport {
    int threads(LifecycleTest test);
}
