package au.net.netstorm.boost.test.timing;

import au.net.netstorm.boost.test.core.Timed;
import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.marker.DefaultMarker;
import au.net.netstorm.boost.test.marker.Marker;

public class DefaultTimer implements Timer {
    private final Marker marker = new DefaultMarker();
    private long start;

    public void startClock() {
        // FIX 2000 Use Clock.
        start = time();
    }

    // FIX 2000 Move stop/start clock stuff out of here.
    public void stopClock(LifecycleTest test) {
        if (isTimed(test)) doTiming(test);
    }

    private void doTiming(LifecycleTest test) {
        long end = time();
        timeOut(test, end);
    }

    private void timeOut(LifecycleTest test, long end) {
        String method = test.getName();
        Class cls = test.getClass();
        TimingSupport timing = test.timingSupport();
        timing.time(cls, method, start, end);
    }

    private long time() {
        return System.currentTimeMillis();
    }

    private boolean isTimed(LifecycleTest test) {
        return marker.is(test, Timed.class);
    }
}
