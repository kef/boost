package au.net.netstorm.boost.provider;

import au.net.netstorm.boost.primordial.PrimordialException;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.reflect.checker.ClassTestChecker;
import au.net.netstorm.boost.test.reflect.checker.DefaultClassTestChecker;

public final class ProviderExceptionAtomicTest extends InteractionTestCase implements HasFixtures {
    ClassTestChecker classer = new DefaultClassTestChecker();
    ProviderException subject;
    ProviderException subjectWithCause;
    Throwable cause;
    String message;

    public void setUpFixtures() {
        subject = new ProviderException(message);
        subjectWithCause = new ProviderException(message, cause);
    }

    public void testException() {
        assertEquals(message, subject.getMessage());
        assertEquals(message, subjectWithCause.getMessage());
        assertEquals(cause, subjectWithCause.getCause());
    }

    public void testStructure() {
        classer.checkSubclassOf(ProviderException.class, PrimordialException.class);
    }
}
