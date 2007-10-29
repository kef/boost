package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.test.lifecycle.LifecycleTest;

public class DefaultTestThreadCreator implements TestThreadCreator {
    private final EdgeClass classer = new DefaultEdgeClass();

    public Thread[] create(LifecycleTest test, int count) {
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
}
