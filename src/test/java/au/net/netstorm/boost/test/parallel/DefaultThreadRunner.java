package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.lifecycle.TestLifecycle;

public class DefaultThreadRunner implements ThreadRunner {
    private final TestEngine engine = new DefaultTestEngine();
    private final TestLifecycle lifecycle;
    private final LifecycleTest test;
    private final String methodName;

    public DefaultThreadRunner(LifecycleTest test, String methodName) {
        this.test = test;
        this.methodName = methodName;
        this.lifecycle = test.testLifecycle();
    }

    public void run() {
        engine.run(test, lifecycle, methodName);
    }
}
