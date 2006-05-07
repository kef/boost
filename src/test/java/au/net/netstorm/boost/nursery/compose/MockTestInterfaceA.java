package au.net.netstorm.boost.nursery.compose;

import junit.framework.Assert;

final class MockTestInterfaceA extends Assert implements TestInterfaceA {
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
