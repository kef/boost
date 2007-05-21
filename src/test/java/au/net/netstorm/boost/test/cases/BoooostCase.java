package au.net.netstorm.boost.test.cases;

import au.net.netstorm.boost.retire.reflect.AssertTestChecker;
import au.net.netstorm.boost.retire.reflect.DefaultAssertTestChecker;
import junit.framework.TestCase;

// SUGGEST Remove the need for this altogether.
// SUGGEST Check bottom level classes are final.
// SUGGEST Check no-arg (single) constructor.

/**
 * This class acts as a buffer to get us out of the
 * broken world` of JUnit.
 */
// OK GenericIllegalRegexp|LineLength {
public abstract class BoooostCase extends TestCase {
    private final AssertTestChecker assertTestChecker = new DefaultAssertTestChecker();

    public void runBare() {
        // DO NOT super.runBare()!!!  We are deliberately taking over the pony show.
        noInheritance();
    }

    protected final void setUp() throws Exception {
        noInheritance();
    }

    protected final void tearDown() throws Exception {
        noInheritance();
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

    private void noInheritance() {
        throw new IllegalStateException("To use, override runBare() and invoke lifecycle methods on your test.  See examples.");
    }

    private static void suffer() {
        throw new UnsupportedOperationException("Use assertEquals(true|false, expected) ... assertTrue/assertFalse precludes refactoring opportunities (_x_)");
    }
}
// } OK GenericIllegalRegexp|LineLength - Abstract is ok we're getting out of JUnit.  Abusing others is fine if they are doing the wrong thing ;-)
