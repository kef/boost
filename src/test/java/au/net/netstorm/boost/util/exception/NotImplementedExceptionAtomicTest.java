package au.net.netstorm.boost.util.exception;

import junit.framework.TestCase;

public final class NotImplementedExceptionAtomicTest extends TestCase {

    public void testType() {
        NotImplementedException exception = new NotImplementedException();
        assertTrue(exception instanceof RuntimeException);
    }
}