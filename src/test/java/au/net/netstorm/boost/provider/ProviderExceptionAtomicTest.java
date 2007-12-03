package au.net.netstorm.boost.provider;

import au.net.netstorm.boost.primordial.PrimordialException;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.HasFixtures;
import au.net.netstorm.boost.test.marker.LazyFields;
import au.net.netstorm.boost.test.reflect.checker.ClassTestChecker;
import au.net.netstorm.boost.test.reflect.checker.DefaultClassTestChecker;

public final class ProviderExceptionAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
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
