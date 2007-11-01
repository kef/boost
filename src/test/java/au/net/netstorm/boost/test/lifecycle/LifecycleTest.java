package au.net.netstorm.boost.test.lifecycle;

import au.net.netstorm.boost.test.core.RunnableTest;
import au.net.netstorm.boost.test.exception.ThrowableSupport;

public interface LifecycleTest extends RunnableTest {
    TestLifecycle testLifecycle();

    TestThreadLifecycle threadLifecycle();

    ThrowableSupport throwableSupport();
}
