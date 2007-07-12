package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.lifecycle.TestLifecycle;
import au.net.netstorm.boost.test.specific.ImplementationSpecificProvider;
import au.net.netstorm.boost.test.specific.InterfaceSpecificProvider;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public abstract class InteractionTestCase extends LifecycleTestCase implements UsesExpectations, UsesAutoMocks {

    protected InteractionTestCase() {
        initSpecifics();
    }

    public TestLifecycle testLifecycle() {
        return new InteractionTestLifecycle(this);
    }

    // FIX 2076 Delegate.
    private void initSpecifics() {
        specifics.add(Interface.class, new InterfaceSpecificProvider());
        specifics.add(Implementation.class, new ImplementationSpecificProvider());
    }
}
