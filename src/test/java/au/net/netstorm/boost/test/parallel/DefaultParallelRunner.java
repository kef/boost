package au.net.netstorm.boost.test.parallel;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeMethod;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeMethod;
import au.net.netstorm.boost.test.lifecycle.LifecycleTest;

// FIX 2000 Use or Lose.
public class DefaultParallelRunner implements ParallelRunner {
    private static final Object[] NO_PARAMETERS = new Object[]{};
    private final EdgeMethod methoder = new DefaultEdgeMethod();
    private final EdgeClass classer = new DefaultEdgeClass();

    public void run(LifecycleTest test, int threads) throws Throwable {
        // FIX 2000 Make this bad boy multi-threaded.
        Class cls = test.getClass();
        Object[] refs = getObjects(cls);
        Method[] methods = getTestMethods(cls);
        execute(refs, methods);
    }

    private Object[] getObjects(Class cls) {
        Object ref = classer.newInstance(cls);
        return new Object[]{ref};
    }

    // FIX 2000 Extract to another class?
    private Method[] getTestMethods(Class cls) {
        List result = new ArrayList();
        Method[] all = cls.getDeclaredMethods();
        for (int i = 0; i < all.length; i++) {
            Method method = all[i];
            String name = method.getName();
            if (name.startsWith("test")) result.add(method);
        }
        return (Method[]) result.toArray(new Method[]{});
    }

    private void execute(Object[] refs, Method[] methods) {
        for (int i = 0; i < refs.length; i++) {
            runTest(refs[i], methods);
        }
    }

    private void runTest(Object ref, Method[] methods) {
        for (int i = 0; i < methods.length; i++) {
            methoder.invoke(methods[i], ref, NO_PARAMETERS);
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
