package au.net.netstorm.boost.util.nullo;

import junit.framework.TestCase;

public class NullMasterAtomicTest extends TestCase {
    NullMaster master = new NullMaster();

    public void testNoException() {
        master.check(this);
    }

    // FIXME: SC523 Replace with normal test method.
    public void failNull() {
        try {
            master.check(null);
            fail();
        } catch (IllegalArgumentException expected) { }
    }
}
