package au.net.netstorm.boost.pebble.onion;

import junit.framework.TestCase;

public final class BermudaOnionAtomicTest extends TestCase {
    private Object ref = new Object();

    public void testOnionize() {
        Onion onion = new BermudaOnion();
        Object layeredObject = onion.onionize(ref);
        assertSame(ref, layeredObject);
    }
}
