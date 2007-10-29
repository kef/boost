package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeThread;
import au.net.netstorm.boost.edge.java.lang.EdgeThread;
import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.lifecycle.TestLifecycle;

public class DefaultTestLifecycleRunner implements TestLifecycleRunner {
    private final TestExceptionHandler handler = new DefaultTestExceptionHandler();
    private final TestThreadCreator creator = new DefaultTestThreadCreator();
    private final EdgeThread threader = new DefaultEdgeThread();

    public void run(LifecycleTest test) throws Throwable {
        TestLifecycle lifecycle = test.testLifecycle();
        boolean successful = false;
        try {
            doExecute(test, lifecycle);
            handler.checkExceptions();
            successful = true;
        } finally {
            lifecycle.cleanup(successful);
        }
    }

    private void doExecute(LifecycleTest test, TestLifecycle lifecycle) {
        lifecycle.pre();
        runThreads(test);
        lifecycle.post();
    }

    private void runThreads(LifecycleTest test) {
        Thread[] threads = creator.create(test);
        start(threads);
        join(threads);
    }

    private void start(Thread[] threads) {
        for (int i = 0; i < threads.length; i++) threader.start(threads[i]);
    }

    private void join(Thread[] threads) {
        for (int i = 0; i < threads.length; i++) threader.join(threads[i]);
    }
}
