package au.net.netstorm.boost.spider.onion.layer.scrunch;

import au.net.netstorm.boost.gunge.core.LifecycleTestCase;
import au.net.netstorm.boost.gunge.marker.HasFixtures;
import au.net.netstorm.boost.gunge.marker.LazyFields;
import au.net.netstorm.boost.primordial.BoooostException;

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