package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.test.lifecycle.LifecycleTest;

// FIX 2000 Use or Lose.
public class DefaultParallelRunner implements ParallelRunner {
    private final EdgeClass classer = new DefaultEdgeClass();

    public void run(LifecycleTest test, int threadCount) throws Throwable {
        // FIX 2000 Make this bad boy multi-threaded.
        Thread[] threads = getThreads(test, threadCount);
        execute(threads);
    }

    // FIX 2000 Tidy this up.
    private Thread[] getThreads(LifecycleTest test, int count) {
        Thread[] result = new Thread[count];
        Class cls = test.getClass();
        String name = test.getName();
        for (int i = 0; i < count; i++) result[i] = createThread(cls, name);
        return result;
    }

    private Thread createThread(Class cls, String name) {
        Object ref = classer.newInstance(cls);
        Runnable runnable = new DefaultThreadRunner(ref, name);
        return new Thread(runnable);
    }

    private void execute(Thread[] threads) {
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
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
}
