package au.net.netstorm.boost.nursery.pebble;

import junit.framework.TestCase;

public final class NoNewerInterfaceExceptionAtomicTest extends TestCase {
    private static final Class CLASS = Pebble.class;
    private static final String EXCEPTION_MESSAGE = "No newer interface yabadabadoo found for class "+CLASS.getName();

    public void testException() {
        Exception exception = new NoNewerInterfaceException("yabadabadoo", CLASS);
        String message = exception.getMessage();
        assertEquals(EXCEPTION_MESSAGE, message);
    }
}
