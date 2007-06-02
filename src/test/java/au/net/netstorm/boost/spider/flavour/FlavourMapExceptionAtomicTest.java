package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.primordial.BoooostException;
import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.UsesAutoMocks;

public final class FlavourMapExceptionAtomicTest extends InteractionTestCase implements HasSubjects, UsesAutoMocks {
    BoooostException subject;
    FlavouredInterface flavoured;
    String reason;

    public void setupSubjects() {
        subject = new FlavourMapException(flavoured, reason);
    }

    public void testException() {
        String result = subject.getMessage();
        assertEquals(reason + ": " + flavoured, result);
    }
}
