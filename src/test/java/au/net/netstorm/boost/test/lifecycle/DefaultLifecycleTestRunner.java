package au.net.netstorm.boost.test.lifecycle;

import java.io.PrintStream;
import au.net.netstorm.boost.test.core.Timed;
import au.net.netstorm.boost.test.exception.ThrowableSupport;
import au.net.netstorm.boost.test.marker.DefaultMarker;
import au.net.netstorm.boost.test.marker.Marker;
import au.net.netstorm.boost.test.parallel.ParallelSupport;
import au.net.netstorm.boost.test.timing.TimingSupport;

public final class DefaultLifecycleTestRunner implements LifecycleTestRunner {
    private final Marker marker = new DefaultMarker();
    private final LifecycleTest testCase;
    private ThrowableSupport throwableSupport;
    // FIX 2000 Use or snooze.
    private ParallelSupport parallelSupport;
    // FIX 2000 Use or lose.
    private TimingSupport timingSupport;
    private TestLifecycle lifecycle;
    private long start;

    public DefaultLifecycleTestRunner(LifecycleTest testCase) {
        this.testCase = testCase;
    }

    public void run() throws Throwable {
        init();
        runit();
    }

    private void init() {
        lifecycle = testCase.testLifecycle();
        throwableSupport = testCase.throwableSupport();
        timingSupport = testCase.timingSupport();
        parallelSupport = testCase.parallelSupport();
    }

    private void runit() throws Throwable {
        boolean successful = true;
        try {
            runMe();
        }
        catch (Throwable t) {
            successful = false;
            throw throwableSupport.translate(t);
        }
        finally {
            cleanup(successful);
        }
    }

    private void runMe() throws Throwable {
        lifecycle.pre();
        startClock();
        lifecycle.run();
        stopClock();
        lifecycle.post();
    }

    private void startClock() {
        // FIX 2000 Use Clock.
        start = time();
    }

    // FIX 2000 Move stop/start clock stuff out of here.
    private void stopClock() {
        if (isTimed()) doTiming();
    }

    private void doTiming() {
        long duration = getDuration();
        String method = testCase.getName();
        Class cls = testCase.getClass();
        timingSupport.time(cls, method, duration);
    }

    private long getDuration() {
        long end = time();
        return end - start;
    }

    private long time() {
        return System.currentTimeMillis();
    }

    private boolean isTimed() {
        return marker.is(testCase, Timed.class);
    }

    private void cleanup(boolean successful) {
        tryCleanup(lifecycle, successful);
    }

    // OK GenericIllegalRegexp {
    private void tryCleanup(TestLifecycle lifecycle, boolean successful) {
        try {
            lifecycle.cleanup(successful);
        } catch (Throwable t) {
            PrintStream err = System.err;
            err.print("Oopsy daisy, we've alreay barfed ... ");
            t.printStackTrace(err);
        }
    }
    // } OK GenericIllegalRegexp
}
