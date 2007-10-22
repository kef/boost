package au.net.netstorm.boost.test.parallel;

import java.util.List;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.lifecycle.TestLifecycle;

public class DefaultParallelRunner implements ParallelRunner {
    private final EdgeClass classer = new DefaultEdgeClass();

    public void run(LifecycleTest test, int threadCount) throws Throwable {
        Thread[] threads = getThreads(test, threadCount);
        execute(test, threads);
    }

    private void execute(LifecycleTest test, Thread[] threads) throws Throwable {
        doExecute(test, threads);
        checkExceptions();
    }

    private void checkExceptions() throws Throwable {
        List exceptions = DefaultThreadRunner.exceptions;
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
        // FIX 2000 Rename to DefaultRunnableTest.
        Runnable runnable = new DefaultThreadRunner(test, name);
        return new Thread(runnable);
    }

    // FIX 2000 Remove InterruptedException.  Use stateless edge.
    private void doExecute(LifecycleTest test, Thread[] threads) throws InterruptedException {
        TestLifecycle lifecycle = test.testLifecycle();
        pre(lifecycle);
        start(threads);
        join(threads);
        post(lifecycle);
    }

    private void pre(TestLifecycle lifecycle) {
        lifecycle.classPre();
    }

    private void post(TestLifecycle lifecycle) {
        lifecycle.classPost();
    }

    private void start(Thread[] threads) {
        for (int i = 0; i < threads.length; i++) threads[i].start();
    }

    private void join(Thread[] threads) throws InterruptedException {
        for (int i = 0; i < threads.length; i++) threads[i].join();
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