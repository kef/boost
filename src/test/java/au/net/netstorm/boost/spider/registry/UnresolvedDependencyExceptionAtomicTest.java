package au.net.netstorm.boost.spider.registry;

import java.lang.reflect.Field;
import au.net.netstorm.boost.test.core.BoooostCase;

public final class UnresolvedDependencyExceptionAtomicTest extends BoooostCase {
    private Field field;
    private Throwable cause;

    public void testConstructor() {
        RuntimeException exception = new UnresolvedDependencyException(field, cause);
        String message = "Cannot resolve '" + field + "'.";
        checkMessage(exception, message);
        assertEquals(cause, exception.getCause());
    }

    private void checkMessage(RuntimeException exception2, String expected2) {
        String message2 = exception2.getMessage();
        assertEquals(expected2, message2);
    }
}
