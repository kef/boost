package au.net.netstorm.boost.pebble.onion;

import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.BaseReference;
import au.net.netstorm.boost.util.type.WrappedInstance;

public final class BermudaOnionAtomicTest extends InteractionTestCase {
    Onion subject;
    BaseReference resolved;

    public void setupSubjects() {
        subject = new BermudaOnion();
    }

    public void testOnionize() {
        WrappedInstance instance = subject.onionise(resolved);
        assertEquals(resolved, instance);
    }
}
