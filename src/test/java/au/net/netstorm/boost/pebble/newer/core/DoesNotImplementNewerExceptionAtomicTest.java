package au.net.netstorm.boost.pebble.newer.core;

import au.net.netstorm.boost.pebble.core.Pebble;
import junit.framework.TestCase;

public final class DoesNotImplementNewerExceptionAtomicTest extends TestCase {
    private static final Class CLASS = Pebble.class;
    private static final String EXPECTED_MESSAGE = "No newer interface found for class " + CLASS.getName();

    public void testException() {
        Exception actualException = new DoesNotImplementNewerException(CLASS);
        String actualMessage = actualException.getMessage();
        assertEquals(EXPECTED_MESSAGE, actualMessage);
    }
}
