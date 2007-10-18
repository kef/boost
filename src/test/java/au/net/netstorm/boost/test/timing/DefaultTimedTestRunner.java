package au.net.netstorm.boost.test.timing;

import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.lifecycle.TestLifecycle;
import au.net.netstorm.boost.test.marker.DefaultMarker;
import au.net.netstorm.boost.test.marker.Marker;
import au.net.netstorm.boost.test.parallel.Parallel;
import au.net.netstorm.boost.test.parallel.ParallelSupport;

public class DefaultTimedTestRunner implements TimedTestRunner {
    private final Marker marker = new DefaultMarker();
    private ParallelSupport parallel;

    public void run(LifecycleTest test, TestLifecycle lifecycle) throws Throwable {
        init(test);
        runit(test, lifecycle);
    }

    private void init(LifecycleTest test) {
        parallel = test.parallelSupport();
    }

    private void runit(LifecycleTest test, TestLifecycle lifecycle) throws Throwable {
        // FIX 2000 Pass lifecycle through to the multi-threaded case.
        if (isParallel(test)) doMultiThreaded(test);
        else doSingleThreaded(test, lifecycle);
    }

    private void doSingleThreaded(LifecycleTest test, TestLifecycle lifecycle) throws Throwable {
        parallel.single(test, lifecycle);
    }

    private void doMultiThreaded(LifecycleTest test) throws Throwable {
        parallel.multi(test);
    }

    private boolean isParallel(LifecycleTest test) {
        return marker.is(test, Parallel.class);
    }
}
