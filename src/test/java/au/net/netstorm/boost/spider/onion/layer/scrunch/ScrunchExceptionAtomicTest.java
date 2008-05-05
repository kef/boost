package au.net.netstorm.boost.spider.onion.layer.scrunch;

import au.net.netstorm.boost.bullet.primordial.BoooostException;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class ScrunchExceptionAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    BoooostException subject;

    public void setUpFixtures() {
        subject = new ScrunchException();
    }

    public void testSubject() {
        String msg = subject.getMessage();
        assertEquals("The object you are trying to invoke a method on has been made unusable ... SCRUNCH, YOU'RE GONE!", msg);
    }
}