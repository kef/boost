package au.net.netstorm.boost.test.parallel;

import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.lifecycle.TestLifecycle;

public class DefaultThreadRunner implements ThreadRunner {
    private final TestEngine engine = new DefaultTestEngine();
    private final TestLifecycle lifecycle;
    private final LifecycleTest test;
    private final String methodName;
    static List exceptions = new ArrayList();

    public DefaultThreadRunner(LifecycleTest test, String methodName) {
        this.test = test;
        this.methodName = methodName;
        this.lifecycle = test.testLifecycle();
    }

    public void run() {
        try {
            engine.runTest(test, lifecycle, methodName);
        } catch (Throwable t) {
            Throwable throwable = engine.error(test, t);
            exceptions.add(throwable);
        } finally {
            engine.tryCleanup(lifecycle);
        }
    }
}
