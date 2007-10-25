package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.marker.DefaultMarker;
import au.net.netstorm.boost.test.marker.Marker;

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
        if (isParallel(test)) thread.multi(test);
        else thread.single(test);
    }

    // FIX 2180 Maybe 'Parallel' should have a 'getThreadCount()'
    //          which can be used here and passed into ThreadSupport.multi().
    private boolean isParallel(LifecycleTest test) {
        return marker.is(test, Parallel.class);
    }
}
