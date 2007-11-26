package au.net.netstorm.boost.demo.parallel;

import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.parallel.DefaultThreadRunner;
import au.net.netstorm.boost.test.parallel.Errors;
import au.net.netstorm.boost.test.parallel.ThreadRunner;
import au.net.netstorm.boost.util.exception.DefaultThrowableMaster;
import au.net.netstorm.boost.util.exception.ThrowableMaster;

public final class ResolveParallelDemoTest extends InteractionTestCase {
    private static final Integer NUM_THREADS = 2;
    ThreadRunner runner = new DefaultThreadRunner();
    ThrowableMaster tosser = new DefaultThrowableMaster();

    public void testResolveWithMultipleThreads() {
        Runnable fatController = new TrainResolver();
        Errors errors = runner.run(fatController, NUM_THREADS);
        errors.assertOk();
        assertEquals(NUM_THREADS, DefaultRailyard.trainCount);
    }
}
