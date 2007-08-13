package au.net.netstorm.boost.spider.registry;

import java.util.Random;
import au.net.netstorm.boost.primordial.BoooostException;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class WrongInterfaceRegistrationExceptionAtomicTest extends InteractionTestCase implements HasFixtures {
    Implementation impl = new DefaultImplementation(Random.class);
    Interface iface = new DefaultInterface(CharSequence.class);
    BoooostException subject;

    public void testMessage() {
        String actual = subject.getMessage();
        String expected = impl + " does not implement " + iface;
        assertEquals(expected, actual);
    }

    public void setUpFixtures() {
        subject = new WrongInterfaceRegistrationException(impl, iface);
    }
}
