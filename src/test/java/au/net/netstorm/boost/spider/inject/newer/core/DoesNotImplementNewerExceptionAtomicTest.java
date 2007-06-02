package au.net.netstorm.boost.spider.inject.newer.core;

import au.net.netstorm.boost.primordial.BoooostException;
import au.net.netstorm.boost.test.automock.HasSubjects;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.Interface;

public final class DoesNotImplementNewerExceptionAtomicTest extends InteractionTestCase implements HasSubjects {
    BoooostException subject;
    Interface type;
    Interface marker;

    public void setupSubjects() {
        subject = new DoesNotImplementNewerException(type, marker);
    }

    public void testException() {
        String actual = subject.getMessage();
        String expected = type + " should implement " + marker;
        assertEquals(expected, actual);
    }
}
