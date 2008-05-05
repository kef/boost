package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.bullet.primordial.BoooostException;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class WrongRegistrationTypeExceptionAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    Implementation type;
    BoooostException subject;

    public void setUpFixtures() {
        subject = new WrongRegistrationTypeException(type);
    }

    public void testException() {
        String actual = subject.getMessage();
        assertEquals(type + " has a different registration type.", actual);
    }
}
