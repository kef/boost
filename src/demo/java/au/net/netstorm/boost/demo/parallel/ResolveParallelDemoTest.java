package au.net.netstorm.boost.demo.parallel;

import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.LazyFields;
import au.net.netstorm.boost.test.parallel.DefaultThreadRunner;
import au.net.netstorm.boost.test.parallel.Errors;
import au.net.netstorm.boost.test.parallel.ThreadRunner;

public final class ResolveParallelDemoTest extends LifecycleTestCase implements LazyFields {
    private static final Integer NUM_THREADS = 2;
    ThreadRunner runner = new DefaultThreadRunner();

    public void testResolveWithMultipleThreads() {
        Runnable fatController = new TrainResolver();
        Errors errors = runner.run(fatController, NUM_THREADS);
        errors.assertOk();
        assertEquals(NUM_THREADS, DefaultRailyard.trainCount);
    }
}
