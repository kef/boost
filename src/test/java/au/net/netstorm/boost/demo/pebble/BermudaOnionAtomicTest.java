package au.net.netstorm.boost.demo.pebble;

import junit.framework.TestCase;
import au.net.netstorm.boost.util.type.Interface;

public final class BermudaOnionAtomicTest extends TestCase {
    private Interface type;
    private Object ref = new Object();

    public void testOnionize() {
        Onion onion = new BermudaOnion();
        Object layeredObject = onion.onionize(ref, type);
        assertSame(ref, layeredObject);
    }
}
