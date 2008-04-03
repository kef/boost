package au.net.netstorm.boost.gunge.lifecycle;

import au.net.netstorm.boost.gunge.automock.TestFieldInjector;

public final class VerifyExpectations implements TestLifecycleBlock {
    TestFieldInjector fieldInjector;

    public void execute() {
        fieldInjector.verify();
    }
}
