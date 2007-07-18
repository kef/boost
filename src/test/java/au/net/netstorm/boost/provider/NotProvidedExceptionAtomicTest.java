package au.net.netstorm.boost.provider;

import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.reflect.checker.ClassTestChecker;
import au.net.netstorm.boost.test.reflect.checker.DefaultClassTestChecker;

public final class NotProvidedExceptionAtomicTest extends InteractionTestCase implements HasFixtures {
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
