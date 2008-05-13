package au.net.netstorm.boost.sniper.parallel;

import au.net.netstorm.boost.sledge.java.lang.DefaultEdgeThread;
import au.net.netstorm.boost.sledge.java.lang.EdgeThread;

public class DefaultThreadRunner implements ThreadRunner {
    EdgeThread threader = new DefaultEdgeThread();

    public Errors run(Runnable runnable, int count) {
        Errors result = new DefaultErrors();
        run(runnable, count, result);
        return result;
    }

    private void run(Runnable runnable, int count, Errors errors) {
        Thread[] threads = createThreads(runnable, count, errors);
        for (Thread thread : threads) threader.start(thread);
        for (Thread thread : threads) threader.join(thread);
    }

    private Thread[] createThreads(Runnable runnable, int count, Errors errors) {
        Runnable myRunnable = new ExceptionAwareRunnable(runnable, errors);
        Thread[] result = new Thread[count];
        for (int i = 0; i < count; i++) result[i] = new Thread(myRunnable);
        return result;
    }
}
