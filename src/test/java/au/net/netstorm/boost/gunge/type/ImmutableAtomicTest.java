package au.net.netstorm.boost.gunge.type;

import java.io.Serializable;
import au.net.netstorm.boost.sniper.core.BoooostCase;

public class ImmutableAtomicTest extends BoooostCase {
    public void testIsSerializable() {
        assertEquals(true, Serializable.class.isAssignableFrom(Immutable.class));
    }
}
