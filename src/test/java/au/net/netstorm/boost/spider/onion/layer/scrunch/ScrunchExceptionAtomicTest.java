package au.net.netstorm.boost.spider.onion.layer.scrunch;

import au.net.netstorm.boost.primordial.BoostException;
import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;

public final class ScrunchExceptionAtomicTest extends InteractionTestCase implements HasSubjects {
    BoostException subject;

    public void setupSubjects() {
        subject = new ScrunchException();
    }

    public void testSubject() {
        String msg = subject.getMessage();
        assertEquals("The object you are trying to invoke a method on has been made unusable ... SCRUNCH, YOU'RE GONE!", msg);
    }
}