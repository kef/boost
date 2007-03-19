package au.net.netstorm.boost.primordial;

import au.net.netstorm.boost.test.automock.BoooostCase;
import au.net.netstorm.boost.test.reflect.checker.ClassTestChecker;
import au.net.netstorm.boost.test.reflect.checker.DefaultClassTestChecker;

public final class PrimordialExceptionAtomicTest extends BoooostCase {
    private static final String MSG = "some massage";
    private final ClassTestChecker classer = new DefaultClassTestChecker();

    public void testException() {
        BoostException ex = new PrimordialException(MSG);
        String result = ex.getMessage();
        assertEquals(MSG, result);
    }

    public void testStructure() {
        classer.checkSubclassOf(PrimordialException.class, RuntimeException.class);
    }
}
