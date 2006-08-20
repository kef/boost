package au.net.netstorm.boost.util.type;

import junit.framework.TestCase;

import java.io.Serializable;

public class ImmutableAtomicTest extends TestCase {
    public void testIsSerializable() {
        assertTrue(Serializable.class.isAssignableFrom(Immutable.class));
    }
}
