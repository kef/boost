package au.net.netstorm.boost.util.type;

import junit.framework.TestCase;

public final class DefaultDataAtomicTest extends TestCase {
    public void testExtends() {
        checkExtends(Immutable.class);
        checkExtends(NullIntolerant.class);
    }

    private void checkExtends(Class type) {
        assertEquals(true, type.isAssignableFrom(Data.class));
    }
}
