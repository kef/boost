package au.net.netstorm.boost.util.type;

import junit.framework.TestCase;

public final class DefaultDataAtomicTest extends TestCase {
    public void testIsImmutable() {
        assertEquals(true, Immutable.class.isAssignableFrom(Data.class));
    }
}
