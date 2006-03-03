package au.net.netstorm.boost.compose;

import junit.framework.Assert;

final class MockTestInterfaceOne extends Assert implements TestInterfaceOne {
    private boolean called;

    public void call() {
        checkCalledOnce();
        called = true;
    }

    private void checkCalledOnce() {
        assertFalse(called);
    }

    public void init() {
        called = false;
    }
}
