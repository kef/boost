package au.net.netstorm.boost.pebble.onion;

import au.net.netstorm.boost.test.cases.BoooostCase;

public final class BermudaOnionAtomicTest extends BoooostCase {
    private Object ref = new Object();

    public void testOnionize() {
        Onion onion = new BermudaOnion();
        Object layeredObject = onion.onionise(ref);
        assertSame(ref, layeredObject);
    }
}
