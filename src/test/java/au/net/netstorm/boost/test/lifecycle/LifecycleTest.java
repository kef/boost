package au.net.netstorm.boost.test.lifecycle;

import au.net.netstorm.boost.test.core.RunnableTest;
import au.net.netstorm.boost.test.exception.ThrowableSupportProvider;

public interface LifecycleTest extends
        RunnableTest,
        TestLifecycleProvider,
        ThrowableSupportProvider {
}
