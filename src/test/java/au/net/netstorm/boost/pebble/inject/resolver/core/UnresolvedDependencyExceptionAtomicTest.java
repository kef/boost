package au.net.netstorm.boost.pebble.inject.resolver.core;

import au.net.netstorm.boost.test.automock.BoooostCase;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class UnresolvedDependencyExceptionAtomicTest extends BoooostCase {
    private static final Interface INTERFACE = new DefaultInterface(LazyBastard.class);

    public void testException() {
        RuntimeException exception = new UnresolvedDependencyException(INTERFACE);
        String message = exception.getMessage();
        String expected = "Such bugs and goblins in my life.  I cannot resolve " + INTERFACE;
        assertEquals(expected, message);
    }
}