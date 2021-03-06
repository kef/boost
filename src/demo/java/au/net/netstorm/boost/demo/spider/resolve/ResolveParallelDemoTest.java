package au.net.netstorm.boost.demo.spider.resolve;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.parallel.DefaultThreadRunner;
import au.net.netstorm.boost.sniper.parallel.Errors;
import au.net.netstorm.boost.sniper.parallel.ThreadRunner;

// FIX 2318 Scary whoever wrote this.  If this was how my trains ran I'd drive everywhere.
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
