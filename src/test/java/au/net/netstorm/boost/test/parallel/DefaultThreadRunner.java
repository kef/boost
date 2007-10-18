package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.test.lifecycle.LifecycleTest;
import au.net.netstorm.boost.test.lifecycle.TestLifecycle;
import au.net.netstorm.boost.test.reflect.util.DefaultMethodTestUtil;
import au.net.netstorm.boost.test.reflect.util.MethodTestUtil;

public class DefaultThreadRunner implements ThreadRunner {
    private static final Object[] NO_PARAMETERS = {};
    private final MethodTestUtil util = new DefaultMethodTestUtil();
    private final LifecycleTest test;
    private final String methodName;
    private TestLifecycle lifecycle;

    public DefaultThreadRunner(LifecycleTest test, String methodName, TestLifecycle lifecycle) {
        this.test = test;
        this.methodName = methodName;
        this.lifecycle = lifecycle;
    }

    // FIX 2000 Hook timing into here somehow.
    public void run() {
        lifecycle.pre();
        util.invoke(test, methodName, NO_PARAMETERS);
        lifecycle.post();
    }
}
