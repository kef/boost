package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.test.lifecycle.ClassTestLifecycle;

public final class InteractionClassTestLifecycle implements ClassTestLifecycle {
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
