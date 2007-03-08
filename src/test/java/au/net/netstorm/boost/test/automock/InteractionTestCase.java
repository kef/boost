package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.nursery.reflect.checker.AssertTestChecker;
import au.net.netstorm.boost.nursery.reflect.checker.DefaultAssertTestChecker;

public class InteractionTestCase extends PrimordialTestCase {
    private final AssertTestChecker assertTestChecker = new DefaultAssertTestChecker();

    public final void assertEquals(Object[] expected, Object[] actual) {
        assertTestChecker.checkEquals(expected, actual);
    }

    public final void assertEquals(byte[] expected, byte[] actual) {
        assertTestChecker.checkEquals(expected, actual);
    }

    public final void assertEquals(int[] expected, int[] actual) {
        assertTestChecker.checkEquals(expected, actual);
    }

    public final void assertNotEquals(byte[] value1, byte[] value2) {
        assertTestChecker.checkNotEquals(value1, value2);
    }

    public final void assertImmutable(byte[] value1, byte[] value2) {
        assertTestChecker.checkImmutable(value1, value2);
    }
}
