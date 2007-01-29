package au.net.netstorm.boost.nursery.pebble;

import au.net.netstorm.boost.nursery.pebble.BermudaOnion;
import au.net.netstorm.boost.nursery.pebble.Onion;
import au.net.netstorm.boost.util.type.Interface;
import junit.framework.TestCase;

public final class BermudaOnionAtomicTest extends TestCase {
    private Interface type;
    private Object ref = new Object();

    public void testOnionize() {
        Onion onion = new BermudaOnion();
        Object layeredObject = onion.onionize(ref, type);
        assertSame(ref, layeredObject);
    }
}
