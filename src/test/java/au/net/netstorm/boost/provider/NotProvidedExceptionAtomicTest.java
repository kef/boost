package au.net.netstorm.boost.provider;

import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.sniper.reflect.checker.ClassTestChecker;
import au.net.netstorm.boost.sniper.reflect.checker.DefaultClassTestChecker;

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
