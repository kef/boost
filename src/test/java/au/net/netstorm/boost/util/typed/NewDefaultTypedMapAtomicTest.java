package au.net.netstorm.boost.util.typed;

import au.net.netstorm.boost.test.automock.InteractionTestCase;

public final class NewDefaultTypedMapAtomicTest extends InteractionTestCase {
    public void testNewer() {
        assertEquals(DefaultTypedMap.class, NewDefaultTypedMap.CLASS_TO_NU);
    }
}
