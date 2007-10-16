package au.net.netstorm.boost.test.lifecycle;

import au.net.netstorm.boost.test.core.RunnableTest;
import au.net.netstorm.boost.test.exception.ThrowableSupportProvider;
import au.net.netstorm.boost.test.parallel.ParallelSupportProvider;
import au.net.netstorm.boost.test.timing.TimingSupportProvider;

public interface LifecycleTest extends
        RunnableTest,
        NamedTest,
        TestLifecycleProvider,
        ThrowableSupportProvider,
        TimingSupportProvider,
        ParallelSupportProvider {
}
