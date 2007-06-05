package au.net.netstorm.boost.test.cases;

import au.net.netstorm.boost.retire.reflect.AssertTestChecker;
import au.net.netstorm.boost.retire.reflect.DefaultAssertTestChecker;
import junit.framework.TestCase;

// SUGGEST Remove the need for this altogether.
// SUGGEST Check bottom level classes are final.
// SUGGEST Check no-arg (single) constructor.

/**
 * This class acts as a buffer to get us out of the
 * broken world of JUnit.
 */
// FIX 1524 Rename to DoNotUseMeTestCase.
// OK GenericIllegalRegexp|LineLength {
public class BoooostCase extends TestCase {
    private final AssertTestChecker assertTestChecker = new DefaultAssertTestChecker();

    protected void setUp() throws Exception {
        super.setUp();
        gearup();
    }

    protected void tearDown() throws Exception {
        geardown();
        super.tearDown();
    }

    protected void gearup() {
    }

    protected void geardown() {
    }

    public final void assertEquals(Object[] expected, Object[] actual) {
        assertTestChecker.checkEquals(expected, actual);
    }

    public final void assertBagEquals(Object[] expected, Object[] actual) {
        assertTestChecker.checkBagEquals(expected, actual);
    }

    public final void assertEquals(byte[] expected, byte[] actual) {
        assertTestChecker.checkEquals(expected, actual);
    }

    public final void assertEquals(int[] expected, int[] actual) {
        assertTestChecker.checkEquals(expected, actual);
    }

    public final void assertNotEquals(byte[] v1, byte[] v2) {
        assertTestChecker.checkNotEquals(v1, v2);
    }

    public final void assertNotEquals(Object v1, Object v2) {
        assertEquals(false, v1.equals(v2));
    }

    public final void assertNotEquals(int v1, int v2) {
        assertEquals(false, v1 == v2);
    }

    // Boxing should do this for us.

    public final void assertEquals(Boolean expected, boolean actual) {
        assertEquals(expected, Boolean.valueOf(actual));
    }

    public final void assertEquals(Integer expected, int actual) {
        assertEquals(expected, Integer.valueOf(actual));
    }

    // Don't use these variants.

    public static final void assertTrue(boolean expected) {
        suffer();
    }

    public static final void assertTrue(String msg, boolean expected) {
        suffer();
    }

    public static final void assertFalse(boolean expected) {
        suffer();
    }

    public static final void assertFalse(String msg, boolean expected) {
        suffer();
    }

    private static void suffer() {
        throw new UnsupportedOperationException("A proud message from the BOOST factory of happiness ... Use assertEquals(true|false, expected) ... assertTrue/assertFalse precludes refactoring opportunities (_x_)");
    }
}
// } OK GenericIllegalRegexp|LineLength - Chiding others is fine if they are doing the wrong thing ;-)
