package au.net.netstorm.boost.util.nullo;

import junit.framework.TestCase;

public class NullMasterAtomicTest extends TestCase {
    public void testNoException() {
        NullMaster.check(this);
    }

    public void failNull() {
        try {
            NullMaster.check(null);
            fail();
        } catch (IllegalArgumentException expected) { }
    }
}
