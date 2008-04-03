package au.net.netstorm.boost.demo.parallel;

import au.net.netstorm.boost.gunge.core.LifecycleTestCase;
import au.net.netstorm.boost.gunge.marker.LazyFields;
import au.net.netstorm.boost.gunge.parallel.DefaultThreadRunner;
import au.net.netstorm.boost.gunge.parallel.Errors;
import au.net.netstorm.boost.gunge.parallel.ThreadRunner;

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
