package au.net.netstorm.boost.bullet.provider;

import au.net.netstorm.boost.bullet.primmm.PrimordialException;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.reflect.checker.ClassTestChecker;
import au.net.netstorm.boost.sniper.reflect.checker.DefaultClassTestChecker;

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
