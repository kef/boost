package au.net.netstorm.boost.util.separator;

import junit.framework.TestCase;

public final class SeparatorAtomicTest extends TestCase {
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public void testConstant() {
        assertEquals(LINE_SEPARATOR, Separator.LINE);
    }
}