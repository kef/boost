package au.net.netstorm.boost.util.nullo;

import junit.framework.TestCase;

public class NullMasterAtomicTest extends TestCase {
    NullMaster master = new NullMaster();

    public void testNoException() {
        master.check(this, null);
    }

    // FIXME: SC523 Replace with normal test method.
    public void testNull() {
        checkFailNull("foo");
        checkFailNull("bar");
    }

    private void checkFailNull(final String parameter) {
        try {
            master.check(null, parameter);
            fail();
        } catch (IllegalArgumentException expected) {
            assertEquals(parameter + " parameter should not be null", expected.getMessage());
        }
    }
}
