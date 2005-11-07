package au.net.netstorm.boost.time.type;

import junit.framework.TestCase;

public final class MonthSpecOutOfBoundsExceptionAtomicTest extends TestCase {
    private static final MonthSpec JANUARY_2000 = MonthSpecAtomicTest.JANUARY_2000;
    // FIXME: SC502 Check fails with null month spec.
    // FIXME: SC502 Triangulate.

    public void testException() {
        new MonthSpecOutOfBoundsException(JANUARY_2000, null);
    }
}