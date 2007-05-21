package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.primordial.BoostException;
import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.Interface;

public final class WrongRegistrationTypeExceptionAtomicTest extends InteractionTestCase implements HasSubjects {
    Interface type;
    BoostException subject;

    public void setupSubjects() {
        subject = new WrongRegistrationTypeException(type);
    }

    public void testException() {
        String actual = subject.getMessage();
        assertEquals(type + " has a different registration type.", actual);
    }
}
