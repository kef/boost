package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.nursery.reflect.checker.AssertTestChecker;
import au.net.netstorm.boost.nursery.reflect.checker.DefaultAssertTestChecker;
import junit.framework.TestCase;

// SUGGEST Remove the need for this altogether.
// FIX SC600 BREADCRUMB Complete.
// FIX SC600 Check bottom level classes are final.
// FIX SC600 Check no-arg (single) constructor.

// FIX SC600 Redefine setUp() to setup() which does not throw an exception.

// OK GenericIllegalRegexp {
public abstract class BoooostCase extends TestCase {
    // } OK GenericIllegalRegexp
    private final AssertTestChecker assertTestChecker = new DefaultAssertTestChecker();

    protected final void setUp() throws Exception {
        super.setUp();
        setup();
    }

    protected final void tearDown() throws Exception {
        teardown();
        super.tearDown();
    }

    protected void setup() {
    }

    protected void teardown() {
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
}
