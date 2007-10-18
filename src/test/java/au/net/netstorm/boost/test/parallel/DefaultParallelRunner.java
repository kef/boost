package au.net.netstorm.boost.test.parallel;

import java.lang.reflect.Method;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeMethod;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeMethod;
import au.net.netstorm.boost.test.lifecycle.LifecycleTest;

// FIX 2000 Use or Lose.
public class DefaultParallelRunner implements ParallelRunner {
    private static final Class[] NO_PARAMETERS = new Class[]{};
    private final EdgeMethod methoder = new DefaultEdgeMethod();
    private final EdgeClass classer = new DefaultEdgeClass();

    public void run(LifecycleTest test, int threads) throws Throwable {
        // FIX 2000 Make this bad boy multi-threaded.
        Class cls = test.getClass();
        Object[] refs = getObjects(cls);
        execute(test, refs);
    }

    private Object[] getObjects(Class cls) {
        Object ref = classer.newInstance(cls);
        return new Object[]{ref};
    }

    private void execute(LifecycleTest test, Object[] refs) {
        for (int i = 0; i < refs.length; i++) runTest(test, refs[i]);
    }

    private void runTest(LifecycleTest test, Object ref) {
        Method method = getTestMethod(test);
        methoder.invoke(method, ref, NO_PARAMETERS);
    }

    private Method getTestMethod(LifecycleTest test) {
        String testName = test.getName();
        Class cls = test.getClass();
        return classer.getMethod(cls, testName, NO_PARAMETERS);
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
