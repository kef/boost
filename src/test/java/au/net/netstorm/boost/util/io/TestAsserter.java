package au.net.netstorm.boost.util.io;

import junit.framework.Assert;

// FIXME: SC502 This belongs in a more general area.
public final class TestAsserter extends Assert {
    public void assertEquals(byte[] expected, byte[] actual) {
        assertNotNull(expected);
        assertNotNull(actual);
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals("" + i, expected[i], actual[i]);
        }
    }
}
