package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.test.lifecycle.LifecycleTestCase;
import au.net.netstorm.boost.test.lifecycle.TestLifecycle;

public class InteractionTestCase extends LifecycleTestCase implements UsesExpectations {

    public TestLifecycle testLifecycle() {
        return new InteractionTest(this);
    }
}
