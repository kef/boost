package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.primordial.BoooostException;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.HasFixtures;
import au.net.netstorm.boost.test.marker.LazyFields;

public final class FlavourMapExceptionAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    BoooostException subject;
    FlavouredInterface flavoured;
    String reason;

    public void setUpFixtures() {
        subject = new FlavourMapException(flavoured, reason);
    }

    public void testException() {
        String result = subject.getMessage();
        assertEquals(reason + ": " + flavoured + " : []", result);
    }
}
