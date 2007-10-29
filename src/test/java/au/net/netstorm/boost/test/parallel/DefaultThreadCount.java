package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.marker.DefaultMarker;
import au.net.netstorm.boost.test.marker.Marker;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;

public class DefaultThreadCount implements ThreadCount {
    private static final String THREADS = "threads";
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();
    private final Marker marker = new DefaultMarker();

    public int threads(LifecycleTest test) {
        if (!isParallel(test)) return 1;
        else return getThreads(test);
    }

    private boolean isParallel(LifecycleTest test) {
        return marker.is(test, Parallel.class);
    }

    private int getThreads(LifecycleTest test) {
        Object ref = fielder.getInstance(test, THREADS);
        validate(ref);
        return (Integer) ref;
    }

    private void validate(Object threads) {
        checkThreadsIsAvailable(threads);
        checkThreadsIsInteger(threads);
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
