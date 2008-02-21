package au.net.netstorm.boost.spider.register;

import java.util.Random;
import au.net.netstorm.boost.primordial.BoooostException;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.HasFixtures;
import au.net.netstorm.boost.test.marker.LazyFields;
import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class WrongInterfaceRegistrationExceptionAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    Implementation impl = new DefaultImplementation(Random.class);
    Interface iface = new DefaultInterface(CharSequence.class);
    BoooostException subject;

    public void testMessage() {
        // FIX ()   2237 Reinstate.
/*
        String actual = subject.getMessage();
        String expected = impl + " does not implement " + iface;
        assertEquals(expected, actual);
*/
    }

    // FIX ()   2237 Reinstate.
    public void setUpFixtures() {
//        subject = new WrongRegistrationException(impl, iface);
    }
}
