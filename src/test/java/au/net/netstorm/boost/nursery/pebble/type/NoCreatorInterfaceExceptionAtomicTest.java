package au.net.netstorm.boost.nursery.pebble.type;

import au.net.netstorm.boost.nursery.pebble.core.Pebble;
import junit.framework.TestCase;

public final class NoCreatorInterfaceExceptionAtomicTest extends TestCase {
    private static final Class CLASS = Pebble.class;
    private static final String EXCEPTION_MESSAGE = "No creator interface yabadabadoo found for class "+CLASS.getName();

    public void testException() {
        Exception exception = new NoCreatorInterfaceException("yabadabadoo", CLASS);
        String message = exception.getMessage();
        assertEquals(EXCEPTION_MESSAGE, message);
    }
}
