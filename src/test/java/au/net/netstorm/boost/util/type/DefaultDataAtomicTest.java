package au.net.netstorm.boost.util.type;

import au.net.netstorm.boost.test.core.BoooostCase;

public final class DefaultDataAtomicTest extends BoooostCase {
    public void testExtends() {
        checkExtends(Immutable.class);
        checkExtends(NullIntolerant.class);
    }

    private void checkExtends(Class type) {
        assertEquals(true, type.isAssignableFrom(Data.class));
    }
}
