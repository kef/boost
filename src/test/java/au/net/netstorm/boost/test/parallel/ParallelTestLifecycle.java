package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.test.lifecycle.TestLifecycle;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.time.core.Clock;

// FIX 2000 Use or Lose.
public class ParallelTestLifecycle implements TestLifecycle {
    private static final String THREADS = "threads";
    private final ParallelRunner runner = new DefaultParallelRunner();
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();
    private final ParallelTestCase test;
    private Integer threads = 0;
    Clock clock;

    public ParallelTestLifecycle(ParallelTestCase test) {
        this.test = test;
    }

    public void pre() {
        doThreading();
    }

    public void run() throws Throwable {
        runner.run(test, threads);
    }

    public void post() {
    }

    public void cleanup(boolean successful) {
    }

    private void doThreading() {
        Object ref = fielder.getInstance(test, THREADS);
        validate(ref);
        threads = (Integer) ref;
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
