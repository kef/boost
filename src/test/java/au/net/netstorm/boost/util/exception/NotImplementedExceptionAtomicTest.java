package au.net.netstorm.boost.util.exception;

import au.net.netstorm.boost.test.automock.BoooostCase;

public final class NotImplementedExceptionAtomicTest extends BoooostCase {

    // FIX SC050 Tighten this up.
    public void testType() {
        NotImplementedException exception = new NotImplementedException();
        assertTrue(exception instanceof RuntimeException);
    }
}