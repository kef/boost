package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.test.lifecycle.MethodTestLifecycle;

public final class InteractionMethodTestLifecycle implements MethodTestLifecycle {
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
