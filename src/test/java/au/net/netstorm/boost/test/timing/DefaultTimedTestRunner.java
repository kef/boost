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
    private TestLifecycle lifecycle;
    private ParallelSupport parallel;
    private TimingSupport timing;
    private long start;

    public void run(LifecycleTest test) throws Throwable {
        init(test);
        runit(test);
    }

    private void init(LifecycleTest test) {
        lifecycle = test.testLifecycle();
        timing = test.timingSupport();
        parallel = test.parallelSupport();
    }

    private void runit(LifecycleTest test) throws Throwable {
        if (isParallel(test)) doMultiThreaded(test);
        else doSingleThreaded(test);
    }

    private void doSingleThreaded(LifecycleTest test) throws Throwable {
        lifecycle.pre();
        startClock();
        lifecycle.run();
        stopClock(test);
        lifecycle.post();
    }

    private void doMultiThreaded(LifecycleTest test) throws Throwable {
        parallel.run(test);
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
