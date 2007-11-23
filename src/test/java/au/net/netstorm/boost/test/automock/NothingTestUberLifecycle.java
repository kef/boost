package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.test.lifecycle.TestUberLifecycle;

public final class NothingTestUberLifecycle implements TestUberLifecycle {
    public void pre() {
        doNothing();
    }

    public void post() {
        doNothing();
    }

    public void cleanup(boolean successful) {
        doNothing();
    }

    private void doNothing() {
    }
}
