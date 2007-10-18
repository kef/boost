package au.net.netstorm.boost.test.parallel;

import au.net.netstorm.boost.test.reflect.util.DefaultMethodTestUtil;
import au.net.netstorm.boost.test.reflect.util.MethodTestUtil;

public class DefaultThreadRunner implements ThreadRunner {
    private static final Object[] NO_PARAMETERS = {};
    private final MethodTestUtil util = new DefaultMethodTestUtil();
    private final Object ref;
    private final String methodName;

    public DefaultThreadRunner(Object ref, String methodName) {
        this.ref = ref;
        this.methodName = methodName;
    }

    public void run() {
        util.invoke(ref, methodName, NO_PARAMETERS);
    }
}
