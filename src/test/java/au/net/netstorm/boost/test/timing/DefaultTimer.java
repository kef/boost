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

    public void stopClock(LifecycleTest test, String methodName) {
        if (isTimed(test)) doTiming(test, methodName);
    }

    private void doTiming(LifecycleTest test, String methodName) {
        long end = time();
        timeOut(test, methodName, end);
    }

    private void timeOut(LifecycleTest test, String methodName, long end) {
        Class cls = test.getClass();
        TimingSupport timing = test.timingSupport();
        timing.time(cls, methodName, start, end);
    }

    private long time() {
        return System.currentTimeMillis();
    }

    private boolean isTimed(LifecycleTest test) {
        return marker.is(test, Timed.class);
    }
}
