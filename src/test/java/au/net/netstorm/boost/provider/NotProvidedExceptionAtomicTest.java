package au.net.netstorm.boost.provider;

import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.reflect.checker.ClassTestChecker;
import au.net.netstorm.boost.test.reflect.checker.DefaultClassTestChecker;

public final class NotProvidedExceptionAtomicTest extends InteractionTestCase implements HasFixtures {
    ClassTestChecker classer = new DefaultClassTestChecker();
    NotProvidedException subject;
    Class aClass;

    public void setUpFixtures() {
        subject = new NotProvidedException(aClass);
    }

    public void testMessage() {
        assertEquals(true, subject.getMessage().contains(aClass.toString()));
    }

    public void testStructure() {
        classer.checkSubclassOf(NotProvidedException.class, ProviderException.class);
    }
}
