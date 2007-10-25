package au.net.netstorm.boost.test.parallel;

import java.util.List;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeThread;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeThread;
import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.lifecycle.MethodTestLifecycle;
import au.net.netstorm.boost.test.lifecycle.TestLifecycle;

public class DefaultParallelRunner implements ParallelRunner {
    private final EdgeThread threader = new DefaultEdgeThread();
    private final EdgeClass classer = new DefaultEdgeClass();

    public void run(LifecycleTest test, int threadCount) throws Throwable {
        Thread[] threads = getThreads(test, threadCount);
        execute(test, threads);
    }

    private void execute(LifecycleTest test, Thread[] threads) throws Throwable {
        MethodTestLifecycle methodLifecycle = test.classTestLifecycle();
        boolean successful = false;
        try {
            doExecute(methodLifecycle, threads);
            checkExceptions();
            successful = true;
        } finally {
            cleanup(methodLifecycle, successful);
        }
    }

    private void checkExceptions() throws Throwable {
        List exceptions = DefaultRunnableTest.exceptions;
        if (hasExceptions(exceptions)) rethrow(exceptions);
    }

    private Thread[] getThreads(LifecycleTest test, int count) {
        Class cls = test.getClass();
        String name = test.getName();
        return createThreads(count, cls, name);
    }

    private Thread[] createThreads(int count, Class cls, String name) {
        Thread[] result = new Thread[count];
        for (int i = 0; i < count; i++) result[i] = createThread(cls, name);
        return result;
    }

    private Thread createThread(Class cls, String name) {
        LifecycleTest test = (LifecycleTest) classer.newInstance(cls);
        Runnable runnable = new DefaultRunnableTest(test, name);
        return new Thread(runnable);
    }

    // FIX 2180 Remove InterruptedException.  Use stateless edge.
    private void doExecute(MethodTestLifecycle methodLifecycle, Thread[] threads) throws InterruptedException {
        pre(methodLifecycle);
        start(threads);
        join(threads);
        post(methodLifecycle);
    }

    private void pre(TestLifecycle lifecycle) {
        lifecycle.pre();
    }

    private void post(TestLifecycle lifecycle) {
        lifecycle.post();
    }

    private void cleanup(TestLifecycle lifecycle, boolean successful) {
        lifecycle.cleanup(successful);
    }

    // FIX 2180 Kick off threads at same time.
    private void start(Thread[] threads) {
        for (int i = 0; i < threads.length; i++) threader.start(threads[i]);
    }

    private void join(Thread[] threads) throws InterruptedException {
        for (int i = 0; i < threads.length; i++) threader.join(threads[i]);
    }

    private void rethrow(List exceptions) throws Throwable {
        Throwable exception = (Throwable) exceptions.get(0);
        exceptions.clear();
        throw new Throwable(exception);
    }

    private boolean hasExceptions(List exceptions) {
        return exceptions.size() > 0;
    }
}