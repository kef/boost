package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.test.core.TestTiming;
import au.net.netstorm.boost.test.lifecycle.TestLifecycle;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.time.core.Clock;
import au.net.netstorm.boost.time.core.TimePoint;

// FIX 2000 Use or Lose.
public class ParallelTestLifecycle implements TestLifecycle {
    private static final Class TIMING_MARKER = TestTiming.class;
    private static final String THREADS = "threads";
    FieldTestUtil fielder = new DefaultFieldTestUtil();
    ParallelTestCase test;
    Clock clock;

    public ParallelTestLifecycle(ParallelTestCase test) {
        this.test = test;
    }

    public void pre() {
        doTiming();
        doThreading();
    }

    public void post() {
        doTiming();
    }

    public void cleanup(boolean successful) {
    }

    private void doTiming() {
        if (hasMarker(TIMING_MARKER)) timer();
    }

    private void doThreading() {
        Object threads = fielder.getInstance(test, THREADS);
        validate(threads);
        // FIX 2000 Finish me.
    }

    private void validate(Object threads) {
        checkThreadsIsAvailable(threads);
        checkThreadsIsInteger(threads);
    }

    private boolean hasMarker(Class marker) {
        Class cls = test.getClass();
        return marker.isAssignableFrom(cls);
    }

    private void timer() {
        TimePoint now = clock.now();
        // FIX 2000 Log timing information right here.
    }

    private void checkThreadsIsAvailable(Object threads) {
        if (threads == null)
            throw new IllegalStateException("A field \"" + THREADS + "\" of type Integer must be set!");
    }

    private void checkThreadsIsInteger(Object threads) {
        if (!(threads instanceof Integer))
            throw new IllegalStateException("Field \" " + THREADS + "\" must be an Integer.");
    }
}
