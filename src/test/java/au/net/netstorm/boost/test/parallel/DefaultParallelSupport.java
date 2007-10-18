package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.lifecycle.TestLifecycle;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;

public class DefaultParallelSupport implements ParallelSupport {
    private static final String THREADS = "threads";
    private final BasicRunner basic = new DefaultBasicRunner();
    private final ParallelRunner parallel = new DefaultParallelRunner();
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();

    public void single(LifecycleTest test, TestLifecycle lifecycle) throws Throwable {
        basic.run(test, lifecycle);
    }

    public void multi(LifecycleTest test) throws Throwable {
        int threads = threads(test);
        parallel.run(test, threads);
    }

    private int threads(LifecycleTest test) {
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
