package au.net.netstorm.boost.test.lifecycle;

import java.io.PrintStream;
import au.net.netstorm.boost.test.core.Timed;
import au.net.netstorm.boost.test.exception.ThrowableSupport;
import au.net.netstorm.boost.test.marker.DefaultMarker;
import au.net.netstorm.boost.test.marker.Marker;

public final class DefaultLifecycleTestRunner implements LifecycleTestRunner {
    private final Marker marker = new DefaultMarker();
    private final LifecycleTest testCase;

    public DefaultLifecycleTestRunner(LifecycleTest testCase) {
        this.testCase = testCase;
    }

    public void run() throws Throwable {
        TestLifecycle lifecycle = testCase.testLifecycle();
        ThrowableSupport throwableSupport = testCase.throwableSupport();
        boolean successful = true;
        try {
            run(lifecycle);
        }
        catch (Throwable t) {
            successful = false;
            throw throwableSupport.translate(t);
        }
        finally {
            cleanup(lifecycle, successful);
        }
    }

    private void run(TestLifecycle lifecycle) throws Throwable {
        lifecycle.pre();
        startClock();
        lifecycle.run();
        stopClock();
        lifecycle.post();
    }

    private void stopClock() {
        if (isTimed()) time();
    }

    private void startClock() {
        if (isTimed()) time();
    }

    private boolean isTimed() {
        return marker.is(testCase, Timed.class);
    }

    private void time() {
        // FIX 2000 Complete me.
    }

    private void cleanup(TestLifecycle lifecycle, boolean successful) {
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
