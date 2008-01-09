package au.net.netstorm.boost.util.type;

import au.net.netstorm.boost.test.core.BoooostCase;

import java.io.Serializable;

public class ImmutableAtomicTest extends BoooostCase {
    public void testIsSerializable() {
        assertEquals(true, Serializable.class.isAssignableFrom(Immutable.class));
    }
}
