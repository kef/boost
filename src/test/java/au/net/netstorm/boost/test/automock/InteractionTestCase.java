package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.lifecycle.TestLifecycle;

public abstract class InteractionTestCase extends LifecycleTestCase implements UsesExpectations, UsesAutoMocks {
    public TestLifecycle testLifecycle() {
        return new InteractionTestLifecycle(this, specifics);
    }
}
