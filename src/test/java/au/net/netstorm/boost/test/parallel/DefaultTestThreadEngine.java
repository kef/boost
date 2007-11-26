package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeThread;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeThread;
import au.net.netstorm.boost.test.lifecycle.LifecycleTest;

// FIX (Nov 26, 2007) TESTING 83271 Delete this.
public class DefaultTestThreadEngine implements TestThreadEngine {
    private final ThreadCount counter = new DefaultThreadCount();
    private final EdgeClass classer = new DefaultEdgeClass();
    private final EdgeThread threader = new DefaultEdgeThread();

    public void start(LifecycleTest test) {
        Thread[] threads = create(test);
        start(threads);
        join(threads);
    }

    private void start(Thread[] threads) {
        for (int i = 0; i < threads.length; i++) threader.start(threads[i]);
    }

    private void join(Thread[] threads) {
        for (int i = 0; i < threads.length; i++) threader.join(threads[i]);
    }

    private Thread[] create(LifecycleTest test) {
        int count = counter.threads(test);
        return createThreads(count, test);
    }

    private Thread[] createThreads(int count, LifecycleTest prototype) {
        Thread[] result = new Thread[count];
        for (int i = 0; i < count; i++) result[i] = createThread(prototype);
        return result;
    }

    private Thread createThread(LifecycleTest prototype) {
        LifecycleTest test = clone(prototype);
        Runnable runnable = new DefaultRunnableTest(test);
        return new Thread(runnable);
    }

    private LifecycleTest clone(LifecycleTest prototype) {
        Class cls = prototype.getClass();
        LifecycleTest test = (LifecycleTest) classer.newInstance(cls);
        String name = prototype.getName();
        test.setName(name);
        return test;
    }
}
