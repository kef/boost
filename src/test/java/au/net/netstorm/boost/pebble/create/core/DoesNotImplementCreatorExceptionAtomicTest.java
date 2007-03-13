package au.net.netstorm.boost.pebble.create.core;

import au.net.netstorm.boost.pebble.core.Pebble;
import junit.framework.TestCase;

public final class DoesNotImplementCreatorExceptionAtomicTest extends TestCase {
    private static final Class CLASS = Pebble.class;
    private static final String EXPECTED_MESSAGE = "No creator interface found for class " + CLASS.getName();

    public void testException() {
        Exception actualException = new DoesNotImplementCreatorException(CLASS);
        String actualMessage = actualException.getMessage();
        assertEquals(EXPECTED_MESSAGE, actualMessage);
    }
}
