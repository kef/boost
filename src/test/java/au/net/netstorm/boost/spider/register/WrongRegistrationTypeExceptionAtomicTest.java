package au.net.netstorm.boost.spider.register;

import au.net.netstorm.boost.primordial.BoooostException;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.util.type.Implementation;

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
