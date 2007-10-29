package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.test.lifecycle.TestLifecycle;

public final class InteractionTestLifecycle implements TestLifecycle {
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
