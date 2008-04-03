package au.net.netstorm.boost.provider;

import au.net.netstorm.boost.gunge.core.LifecycleTestCase;
import au.net.netstorm.boost.gunge.marker.HasFixtures;
import au.net.netstorm.boost.gunge.marker.LazyFields;
import au.net.netstorm.boost.gunge.reflect.checker.ClassTestChecker;
import au.net.netstorm.boost.gunge.reflect.checker.DefaultClassTestChecker;

public final class NotProvidedExceptionAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    ClassTestChecker classer = new DefaultClassTestChecker();
    NotProvidedException subject;
    Class aClass;
    private static final int NOT_FOUND = -1;

    public void setUpFixtures() {
        subject = new NotProvidedException(aClass);
    }

    public void testMessage() {
        String message = subject.getMessage();
        String classString = aClass.toString();
        assertEquals(true, message.indexOf(classString) != NOT_FOUND);
    }

    public void testStructure() {
        classer.checkSubclassOf(NotProvidedException.class, ProviderException.class);
    }
}
