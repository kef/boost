package au.net.netstorm.boost.spider.onion.layer.scrunch;

import au.net.netstorm.boost.primordial.BoooostException;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;

public final class ScrunchExceptionAtomicTest extends InteractionTestCase implements HasFixtures {
    BoooostException subject;

    public void setUpFixtures() {
        subject = new ScrunchException();
    }

    public void testSubject() {
        String msg = subject.getMessage();
        assertEquals("The object you are trying to invoke a method on has been made unusable ... SCRUNCH, YOU'RE GONE!", msg);
    }
}