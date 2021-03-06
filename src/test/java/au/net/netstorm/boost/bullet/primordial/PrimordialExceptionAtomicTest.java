package au.net.netstorm.boost.bullet.primordial;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.reflect.checker.ClassTestChecker;
import au.net.netstorm.boost.sniper.reflect.checker.DefaultClassTestChecker;

public final class PrimordialExceptionAtomicTest extends LifecycleTestCase implements LazyFields {
    ClassTestChecker classer = new DefaultClassTestChecker();
    String message;
    Throwable cause;

    public void testException() {
        PrimordialException ex = new PrimordialException(message);
        PrimordialException ex2 = new PrimordialException(message, cause);
        assertEquals(message, ex.getMessage());
        assertEquals(message, ex2.getMessage());
        assertEquals(cause, ex2.getCause());
    }

    public void testStructure() {
        classer.checkSubclassOf(PrimordialException.class, RuntimeException.class);
    }
}
