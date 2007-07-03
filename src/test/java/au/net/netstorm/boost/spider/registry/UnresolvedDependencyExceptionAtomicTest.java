package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.test.core.BoooostCase;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class UnresolvedDependencyExceptionAtomicTest extends BoooostCase {
    private static final Interface INTERFACE = new DefaultInterface(Animal.class);

    public void testException() {
        RuntimeException exception = new UnresolvedDependencyException(INTERFACE);
        String message = exception.getMessage();
        String expected = "Such bugs and goblins in my life. \nI cannot resolve " + INTERFACE;
        assertEquals(expected, message);
    }
}
