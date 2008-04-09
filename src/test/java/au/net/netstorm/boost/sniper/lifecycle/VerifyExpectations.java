package au.net.netstorm.boost.sniper.lifecycle;

import au.net.netstorm.boost.sniper.automock.TestFieldInjector;

public final class VerifyExpectations implements TestLifecycleBlock {
    TestFieldInjector fieldInjector;

    public void execute() {
        fieldInjector.verify();
    }
}
