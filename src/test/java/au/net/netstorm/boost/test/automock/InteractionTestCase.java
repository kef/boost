package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.nursery.reflect.checker.AssertTestChecker;
import au.net.netstorm.boost.nursery.reflect.checker.DefaultAssertTestChecker;

public abstract class InteractionTestCase extends PrimordialTestCase implements UsesMocks {
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

    public final void assertNotEquals(byte[] expected, byte[] actual) {
        assertTestChecker.checkNotEquals(expected, actual);
    }
}
