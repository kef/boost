package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.nursery.reflect.checker.AssertTestChecker;
import au.net.netstorm.boost.nursery.reflect.checker.DefaultAssertTestChecker;

public final class InteractionTestCase extends PrimordialTestCase {
    private final AssertTestChecker assertTestChecker = new DefaultAssertTestChecker();

    public void checkEquals(Object[] expected, Object[] actual) {
        assertTestChecker.checkEquals(expected, actual);
    }

    public void checkEquals(byte[] expected, byte[] actual) {
        assertTestChecker.checkEquals(expected, actual);
    }

    public void assertEquals(int[] expected, int[] actual) {
        assertTestChecker.checkEquals(expected, actual);
    }

    public void assertNotEquals(byte[] value1, byte[] value2) {
        assertTestChecker.checkNotEquals(value1, value2);
    }

    public void assertImmutable(byte[] value1, byte[] value2) {
        assertTestChecker.checkImmutable(value1, value2);
    }
}
