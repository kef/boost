package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.test.lifecycle.LifecycleTest;

// FIX (Nov 26, 2007) TESTING 83271 Delete this.
public class DefaultTestThreadEngine implements TestThreadEngine {

    public void start(LifecycleTest test) {
        Runnable runnable = new DefaultRunnableTest(test);
        runnable.run();
    }
}
