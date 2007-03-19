package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.nursery.reflect.checker.AssertTestChecker;
import au.net.netstorm.boost.nursery.reflect.checker.DefaultAssertTestChecker;
import junit.framework.TestCase;

// SUGGEST Remove the need for this altogether.
// SUGGEST Check bottom level classes are final.
// SUGGEST Check no-arg (single) constructor.

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