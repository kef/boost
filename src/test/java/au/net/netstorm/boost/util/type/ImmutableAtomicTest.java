package au.net.netstorm.boost.util.type;

import java.io.Serializable;
import junit.framework.TestCase;

public class ImmutableAtomicTest extends TestCase {
    public void testIsSerializable() {
        assertEquals(true, Serializable.class.isAssignableFrom(Immutable.class));
    }
}
