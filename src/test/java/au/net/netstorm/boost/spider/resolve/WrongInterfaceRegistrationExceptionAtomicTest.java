package au.net.netstorm.boost.spider.resolve;

import java.util.Random;
import au.net.netstorm.boost.primordial.BoostException;
import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class WrongInterfaceRegistrationExceptionAtomicTest extends InteractionTestCase implements HasSubjects {
    BoostException subject;
    Implementation impl = new DefaultImplementation(Random.class);
    Interface iface = new DefaultInterface(CharSequence.class);

    public void testMessage() {
        String actual = subject.getMessage();
        Class implClassName = impl.getClass();
        Class ifaceName = iface.getType();
        String expected = implClassName + " does not implement " + ifaceName;
        assertEquals(expected, actual);
    }

    public void setupSubjects() {
        subject = new WrongInterfaceRegistrationException(impl, iface);
    }
}
