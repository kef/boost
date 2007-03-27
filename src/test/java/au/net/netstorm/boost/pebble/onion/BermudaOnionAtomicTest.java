package au.net.netstorm.boost.pebble.onion;

import au.net.netstorm.boost.test.cases.BoooostCase;
import au.net.netstorm.boost.util.type.DefaultInstance;
import au.net.netstorm.boost.util.type.Instance;

public final class BermudaOnionAtomicTest extends BoooostCase {
    private Object ref = new Object();
    private Instance instance = new DefaultInstance(ref);

    public void testOnionize() {
        Onion onion = new BermudaOnion();
        Instance layeredObject = onion.onionise(ref);
        assertEquals(instance, layeredObject);
    }
}
