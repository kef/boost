package au.net.netstorm.boost.spider.registry;

import java.util.Random;
import au.net.netstorm.boost.bullet.primordial.BoooostException;
import au.net.netstorm.boost.gunge.type.DefaultImplementation;
import au.net.netstorm.boost.gunge.type.DefaultInterface;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;

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
