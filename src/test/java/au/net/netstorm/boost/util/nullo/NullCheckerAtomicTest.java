package au.net.netstorm.boost.util.nullo;

import junit.framework.TestCase;

public class NullCheckerAtomicTest extends TestCase {
    public void testNoException() {
        NullChecker.check(this);
    }

    public void failNull() {
        try {
            NullChecker.check(null);
            fail();
        } catch (IllegalArgumentException expected) { }
    }
}
