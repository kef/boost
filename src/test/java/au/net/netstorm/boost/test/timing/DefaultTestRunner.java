package au.net.netstorm.boost.test.timing;

import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.marker.DefaultMarker;
import au.net.netstorm.boost.test.marker.Marker;
import au.net.netstorm.boost.test.parallel.Parallel;
import au.net.netstorm.boost.test.parallel.ThreadSupport;

public class DefaultTestRunner implements TestRunner {
    private final Marker marker = new DefaultMarker();
    private ThreadSupport thread;

    public void run(LifecycleTest test) throws Throwable {
        init(test);
        runit(test);
    }

    private void init(LifecycleTest test) {
        thread = test.threadSupport();
    }

    private void runit(LifecycleTest test) throws Throwable {
        if (isParallel(test)) doMultiThreaded(test);
        else doSingleThreaded(test);
    }

    private void doSingleThreaded(LifecycleTest test) throws Throwable {
        thread.single(test);
    }

    private void doMultiThreaded(LifecycleTest test) throws Throwable {
        thread.multi(test);
    }

    private boolean isParallel(LifecycleTest test) {
        return marker.is(test, Parallel.class);
    }
}
