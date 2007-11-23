package au.net.netstorm.boost.test.parallel;

import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.lifecycle.TestLifecycle;

// FIX 81612 Rename TestEngine to TestThreadLifecycleRunner and combine with this class
public class DefaultRunnableTest implements Runnable {
    private final TestEngine engine = new DefaultTestEngine();
    private final TestLifecycle lifecycle;
    private final LifecycleTest test;
    // FIX 81612 this is dodgy - collect from all instances at end of tests, do above fix first.
    static List exceptions = new ArrayList();

    public DefaultRunnableTest(LifecycleTest test) {
        this.test = test;
        this.lifecycle = test.lifecycle();
    }

    public void run() {
        try {
            engine.runTest(test, lifecycle);
        } catch (Throwable t) {
            Throwable throwable = engine.error(test, t);
            exceptions.add(throwable);
        } finally {
            engine.tryCleanup(lifecycle);
        }
    }
}
