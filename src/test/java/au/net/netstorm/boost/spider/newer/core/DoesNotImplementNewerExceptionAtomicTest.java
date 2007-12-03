package au.net.netstorm.boost.spider.newer.core;

import au.net.netstorm.boost.primordial.BoooostException;
import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.HasFixtures;
import au.net.netstorm.boost.test.marker.LazyFields;
import au.net.netstorm.boost.util.type.Interface;

public final class DoesNotImplementNewerExceptionAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
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
