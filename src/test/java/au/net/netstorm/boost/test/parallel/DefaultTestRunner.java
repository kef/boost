package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.test.lifecycle.LifecycleTest;

public class DefaultTestRunner implements TestRunner {
    private final MethodLifecycleRunner runner = new DefaultMethodLifecycleRunner();
    private final ThreadCount counter = new DefaultThreadCount();

    public void run(LifecycleTest test) throws Throwable {
        int numThreads = counter.threads(test);
        runner.run(test, numThreads);
    }
}
