package au.net.netstorm.boost.test.lifecycle;

import au.net.netstorm.boost.test.core.RunnableTest;
import au.net.netstorm.boost.test.exception.ThrowableSupportProvider;
import au.net.netstorm.boost.test.parallel.ParallelSupportProvider;
import au.net.netstorm.boost.test.timing.TimingSupportProvider;

// FIX 2183 Revisit and tidy this.
public interface LifecycleTest extends
        RunnableTest,
        NamedTest,
        TestLifecycleProvider,
// FIX 2183 Aggregate into support methods.
        ThrowableSupportProvider,
        TimingSupportProvider,
        ParallelSupportProvider {
}
