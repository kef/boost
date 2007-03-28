package au.net.netstorm.boost.pebble.onion;

import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.BaseReference;
import au.net.netstorm.boost.util.type.WrappedInstance;

public final class BermudaOnionAtomicTest extends InteractionTestCase {
    Onionizer subject;
    BaseReference resolved;

    public void setupSubjects() {
        subject = new BermudaOnionizer();
    }

    public void testOnionize() {
        WrappedInstance instance = subject.onionise(resolved);
        assertEquals(resolved, instance);
    }
}
