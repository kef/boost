package au.net.netstorm.boost.util.type;

import java.io.Serializable;
import au.net.netstorm.boost.gunge.core.BoooostCase;

public class ImmutableAtomicTest extends BoooostCase {
    public void testIsSerializable() {
        assertEquals(true, Serializable.class.isAssignableFrom(Immutable.class));
    }
}
