package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.lifecycle.TestLifecycle;

// FIX 2000 Use or Lose.
public class DefaultParallelRunner implements ParallelRunner {
    private final EdgeClass classer = new DefaultEdgeClass();

    public void run(LifecycleTest test, int threadCount, TestLifecycle lifecycle) throws Throwable {
        Thread[] threads = getThreads(test, threadCount, lifecycle);
        execute(threads);
    }

    private Thread[] getThreads(LifecycleTest test, int count, TestLifecycle lifecycle) {
        Class cls = test.getClass();
        String name = test.getName();
        return createThreads(count, cls, name, lifecycle);
    }

    private Thread[] createThreads(int count, Class cls, String name, TestLifecycle lifecycle) {
        Thread[] result = new Thread[count];
        for (int i = 0; i < count; i++) result[i] = createThread(cls, name, lifecycle);
        return result;
    }

    private Thread createThread(Class cls, String name, TestLifecycle lifecycle) {
        LifecycleTest test = (LifecycleTest) classer.newInstance(cls);
        Runnable runnable = new DefaultThreadRunner(test, name, lifecycle);
        return new Thread(runnable);
    }

    // FIX 2000 Remove InterruptedException.  Use stateless edge.
    private void execute(Thread[] threads) throws InterruptedException {
        start(threads);
        join(threads);
    }

    private void start(Thread[] threads) {
        for (int i = 0; i < threads.length; i++) threads[i].start();
    }

    private void join(Thread[] started) throws InterruptedException {
        for (int i = 0; i < started.length; i++) started[i].join();
    }
}