package au.net.netstorm.boost.test.lifecycle;

import au.net.netstorm.boost.test.core.RunnableTest;
import au.net.netstorm.boost.test.exception.ThrowableSupport;
import au.net.netstorm.boost.test.timing.TimedTest;

public interface LifecycleTest extends RunnableTest, TimedTest {
    TestLifecycle testLifecycle();

    TestThreadLifecycle threadLifecycle();

    ThrowableSupport throwableSupport();
}
