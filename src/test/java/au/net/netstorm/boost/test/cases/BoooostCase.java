package au.net.netstorm.boost.test.cases;

import au.net.netstorm.boost.nursery.reflect.checker.AssertTestChecker;
import au.net.netstorm.boost.nursery.reflect.checker.DefaultAssertTestChecker;
import junit.framework.TestCase;

// SUGGEST Remove the need for this altogether.
// SUGGEST Check bottom level classes are final.
// SUGGEST Check no-arg (single) constructor.

// FIX 1715 Move test cases into appropriate area.

// OK GenericIllegalRegexp {
public abstract class BoooostCase extends TestCase {
    // } OK GenericIllegalRegexp
    private final AssertTestChecker assertTestChecker = new DefaultAssertTestChecker();

    protected final void setUp() throws Exception {
        super.setUp();
        gearup();
    }

    protected final void tearDown() throws Exception {
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

    public final void assertNotEquals(byte[] expected, byte[] actual) {
        assertTestChecker.checkNotEquals(expected, actual);
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

    // OK LineLength {
    private static void suffer() {
        throw new UnsupportedOperationException("Use assertEquals(true|false, expected) ... assertTrue/assertFalse precludes refactoring opportunities (_x_)");
    }
    // } OK LineLength - Abusing others is fine if they are doing the wrong thing ;-)
}
