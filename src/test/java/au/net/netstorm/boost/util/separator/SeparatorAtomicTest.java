package au.net.netstorm.boost.util.separator;

import au.net.netstorm.boost.test.core.BoooostCase;
import au.net.netstorm.boost.test.reflect.util.DefaultClassTestUtil;

public final class SeparatorAtomicTest extends BoooostCase {
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    // FIX SC600 Strengthen this to ensure constructor is private.
    // FIX SC600 Make a test utility or add a checkstyle check to ensure this.
    public void testPrivateConstructor() {
        new DefaultClassTestUtil().newInstance(Separator.class);
    }

    public void testConstant() {
        assertEquals(LINE_SEPARATOR, Separator.LINE);
    }
}
