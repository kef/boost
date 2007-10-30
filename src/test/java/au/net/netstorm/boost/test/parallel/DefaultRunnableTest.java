package au.net.netstorm.boost.test.parallel;

import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.lifecycle.TestThreadLifecycle;

// FIX 81612 Rename TestEngine to TestThreadLifecycleRunner and combine with this class
public class DefaultRunnableTest implements Runnable {
    private final TestEngine engine = new DefaultTestEngine();
    private final TestThreadLifecycle threadLifecycle;
    private final LifecycleTest test;
    private final String methodName;
    // FIX 81612 this is dodgy - collect from all instances at end of tests, do above fix first.
    static List exceptions = new ArrayList();

    public DefaultRunnableTest(LifecycleTest test, String methodName) {
        this.test = test;
        this.methodName = methodName;
        this.threadLifecycle = test.threadLifecycle();
    }

    public void run() {
        try {
            engine.runTest(test, threadLifecycle, methodName);
        } catch (Throwable t) {
            Throwable throwable = engine.error(test, t);
            exceptions.add(throwable);
        } finally {
            engine.tryCleanup(threadLifecycle);
        }
    }
}
