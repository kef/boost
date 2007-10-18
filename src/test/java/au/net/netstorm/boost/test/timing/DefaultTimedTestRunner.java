package au.net.netstorm.boost.test.timing;

import au.net.netstorm.boost.test.core.Timed;
import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.lifecycle.TestLifecycle;
import au.net.netstorm.boost.test.marker.DefaultMarker;
import au.net.netstorm.boost.test.marker.Marker;
import au.net.netstorm.boost.test.parallel.Parallel;
import au.net.netstorm.boost.test.parallel.ParallelSupport;

public class DefaultTimedTestRunner implements TimedTestRunner {
    private final Marker marker = new DefaultMarker();
    private ParallelSupport parallel;
    private TimingSupport timing;
    private long start;

    public void run(LifecycleTest test, TestLifecycle lifecycle) throws Throwable {
        init(test);
        runit(test, lifecycle);
    }

    private void init(LifecycleTest test) {
        timing = test.timingSupport();
        parallel = test.parallelSupport();
    }

    private void runit(LifecycleTest test, TestLifecycle lifecycle) throws Throwable {
        if (isParallel(test)) doMultiThreaded(test, lifecycle);
        else doSingleThreaded(test, lifecycle);
    }

    private void doSingleThreaded(LifecycleTest test, TestLifecycle lifecycle) throws Throwable {
        lifecycle.pre();
        startClock();
        test.runTest();
        stopClock(test);
        lifecycle.post();
    }

    private void doMultiThreaded(LifecycleTest test, TestLifecycle lifecycle) throws Throwable {
        parallel.run(test, lifecycle);
    }

    private boolean isParallel(LifecycleTest test) {
        return marker.is(test, Parallel.class);
    }

    private void startClock() {
        // FIX 2000 Use Clock.
        start = time();
    }

    // FIX 2000 Move stop/start clock stuff out of here.
    private void stopClock(LifecycleTest test) {
        if (isTimed(test)) doTiming(test);
    }

    private void doTiming(LifecycleTest test) {
        String method = test.getName();
        Class cls = test.getClass();
        long end = time();
        timing.time(cls, method, start, end);
    }

    private long time() {
        return System.currentTimeMillis();
    }

    private boolean isTimed(LifecycleTest test) {
        return marker.is(test, Timed.class);
    }
}
