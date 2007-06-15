package au.net.netstorm.boost.spider.inject.newer.core;

import au.net.netstorm.boost.primordial.BoooostException;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.Interface;

public final class DoesNotImplementNewerExceptionAtomicTest extends InteractionTestCase implements HasFixtures {
    BoooostException subject;
    Interface type;
    Interface marker;

    public void setUpFixtures() {
        subject = new DoesNotImplementNewerException(type, marker);
    }

    public void testException() {
        String actual = subject.getMessage();
        String expected = type + " should implement " + marker;
        assertEquals(expected, actual);
    }
}
