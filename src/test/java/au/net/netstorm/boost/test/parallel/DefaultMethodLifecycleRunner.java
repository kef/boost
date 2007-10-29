package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeThread;
import au.net.netstorm.boost.edge.java.lang.EdgeThread;
import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.lifecycle.MethodTestLifecycle;

public class DefaultMethodLifecycleRunner implements MethodLifecycleRunner {
    private final TestExceptionHandler handler = new DefaultTestExceptionHandler();
    private final TestThreadCreator creator = new DefaultTestThreadCreator();
    private final EdgeThread threader = new DefaultEdgeThread();

    public void run(LifecycleTest test, int numThreads) throws Throwable {
        MethodTestLifecycle methodLifecycle = test.methodTestLifecycle();
        boolean successful = false;
        try {
            doExecute(methodLifecycle, test, numThreads);
            handler.checkExceptions();
            successful = true;
        } finally {
            methodLifecycle.cleanup(successful);
        }
    }

    private void doExecute(MethodTestLifecycle methodLifecycle, LifecycleTest test, int numThreads) {
        Thread[] threads = creator.create(test, numThreads);
        methodLifecycle.pre();
        start(threads);
        join(threads);
        methodLifecycle.post();
    }

    private void start(Thread[] threads) {
        for (int i = 0; i < threads.length; i++) threader.start(threads[i]);
    }

    private void join(Thread[] threads) {
        for (int i = 0; i < threads.length; i++) threader.join(threads[i]);
    }
}
