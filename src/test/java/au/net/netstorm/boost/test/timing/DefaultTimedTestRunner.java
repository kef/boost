package au.net.netstorm.boost.test.timing;

import au.net.netstorm.boost.test.core.Timed;
import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.lifecycle.TestLifecycle;
import au.net.netstorm.boost.test.marker.DefaultMarker;
import au.net.netstorm.boost.test.marker.Marker;
import au.net.netstorm.boost.test.parallel.Parallel;
import au.net.netstorm.boost.test.parallel.ParallelSupport;

public class DefaultTimedTestRunner implements TimedTestRunner {
    private final Marker marker = new DefaultMarker();
    private TestLifecycle lifecycle;
    private ParallelSupport parallel;
    private TimingSupport timing;
    private long start;

    public void run(LifecycleTest test) throws Throwable {
        init(test);
        runit(test);
    }

    private void init(LifecycleTest test) {
        lifecycle = test.testLifecycle();
        timing = test.timingSupport();
        parallel = test.parallelSupport();
    }

    private void runit(LifecycleTest test) throws Throwable {
        parallise(test);
        lifecycle.pre();
        startClock();
        lifecycle.run();
        stopClock(test);
        lifecycle.post();
    }

    private void parallise(LifecycleTest test) {
        if (!isParallel(test)) return;
        int threads = parallel.threads(test);
    }

    // FIX 2000 Remove this gumf.
//    private void startYourEngines() {
//        for (int i = 0; i < clients.length; i++) {
//            removeSslOverhead(i);
//            RunnableClient runnableClient = new RunnableClient(clients[i]);
//            Thread t = new Thread(runnableClient);
//            t.start();
//        }
//    }
//
//    private void go() throws InterruptedException {
//        synchronized (lock) {
//            lock.notifyAll();
//            while (!done()) {
//                lock.wait(100L);
//            }
//        }
//    }
//
//    private boolean done() {
//        return clientCount <= 1;
//    }
//
//    private void removeSslOverhead(int i) {
//        clients[i].ping();
//    }
//
//    class RunnableClient implements Runnable {
//        private CrowApi client;
//
//        RunnableClient(CrowApi client) {
//            this.client = client;
//        }
//
//        public void run() {
//            hangAbout();
//            timer.timeIt(new Block() {
//                public void execute() {
//                    client.getKeyByClass(TEMPORAL_CLASS);
//                }
//            }, "Temporal getKeyByClass", DURATION);
//            clientCount--;
//        }
//
//        private void hangAbout() {
//            synchronized (lock) {
//                try {
//                    lock.wait();
//                } catch (InterruptedException e) {}
//            }
//        }
//    }

    private boolean isParallel(LifecycleTest test) {
        return marker.is(test, Parallel.class);
    }

    private void startClock() {
        // FIX 2000 Use Clock.
        start = time();
    }

    // FIX 2000 Move stop/start clock stuff out of here.
    private void stopClock(LifecycleTest test) {
        if (isTimed(test)) doTiming(test);
    }

    private void doTiming(LifecycleTest test) {
        String method = test.getName();
        Class cls = test.getClass();
        long end = time();
        timing.time(cls, method, start, end);
    }

    private long time() {
        return System.currentTimeMillis();
    }

    private boolean isTimed(LifecycleTest test) {
        return marker.is(test, Timed.class);
    }
}
