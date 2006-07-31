package au.net.netstorm.boost.util.exception;

import junit.framework.TestCase;

public final class NotImplementedExceptionAtomicTest extends TestCase {

    // FIX SC050 Tighten this up.
    public void testType() {
        NotImplementedException exception = new NotImplementedException();
        assertTrue(exception instanceof RuntimeException);
    }
}