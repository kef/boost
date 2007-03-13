package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.nursery.reflect.checker.AssertTestChecker;
import au.net.netstorm.boost.nursery.reflect.checker.DefaultAssertTestChecker;
import junit.framework.TestCase;

// FIX 1715 Remove me.

// FIX BREADCRUMB 1715 Over here.
public class AssertTestCase extends TestCase {
    private final AssertTestChecker asserter = new DefaultAssertTestChecker();

    public void assertEquals(Object[] expected, Object[] actual) {
        asserter.checkEquals(expected, actual);
    }

    public void assertEquals(byte[] expected, byte[] actual) {
        asserter.checkEquals(expected, actual);
    }

    public void assertEquals(int[] expected, int[] actual) {
        asserter.checkEquals(expected, actual);
    }

    public void assertNotEquals(byte[] expected, byte[] actual) {
        asserter.checkNotEquals(expected, actual);
    }
}
