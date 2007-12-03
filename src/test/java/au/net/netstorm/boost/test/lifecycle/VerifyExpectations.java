package au.net.netstorm.boost.test.lifecycle;

import au.net.netstorm.boost.test.automock.TestFieldInjector;

public final class VerifyExpectations implements TestLifecycleBlock {
    TestFieldInjector fieldInjector;

    public void execute() {
        fieldInjector.verify();
    }
}
