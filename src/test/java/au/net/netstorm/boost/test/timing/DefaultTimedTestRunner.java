package au.net.netstorm.boost.test.timing;

import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.lifecycle.TestLifecycle;
import au.net.netstorm.boost.test.marker.DefaultMarker;
import au.net.netstorm.boost.test.marker.Marker;
import au.net.netstorm.boost.test.parallel.Parallel;
import au.net.netstorm.boost.test.parallel.ParallelSupport;

public class DefaultTimedTestRunner implements TimedTestRunner {
    private final Timer timer = new DefaultTimer();
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
        if (isParallel(test)) doMultiThreaded(test);
        else doSingleThreaded(test, lifecycle);
    }

    // FIX 2000 Move this out to another class!!!!!!!!!!!!!!!!
    private void doSingleThreaded(LifecycleTest test, TestLifecycle lifecycle) throws Throwable {
        lifecycle.pre();
        timer.startClock();
        test.runTest();
        timer.stopClock(test);
        lifecycle.post();
    }

    private void doMultiThreaded(LifecycleTest test) throws Throwable {
        parallel.run(test);
    }

    private boolean isParallel(LifecycleTest test) {
        return marker.is(test, Parallel.class);
    }
}
