package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeThread;
import au.net.netstorm.boost.edge.java.lang.EdgeThread;
import au.net.netstorm.boost.test.lifecycle.LifecycleTest;

// FIX (Nov 26, 2007) TESTING 83271 Delete this.
public class DefaultTestThreadEngine implements TestThreadEngine {
    private final EdgeThread threader = new DefaultEdgeThread();

    public void start(LifecycleTest test) {
        Thread thread = createThread(test);
        threader.start(thread);
        threader.join(thread);
    }

    private Thread createThread(LifecycleTest test) {
        Runnable runnable = new DefaultRunnableTest(test);
        return new Thread(runnable);
    }
}
