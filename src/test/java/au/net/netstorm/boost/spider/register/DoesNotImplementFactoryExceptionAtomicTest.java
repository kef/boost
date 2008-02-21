package au.net.netstorm.boost.spider.register;

import au.net.netstorm.boost.test.core.LifecycleTestCase;
import au.net.netstorm.boost.test.marker.HasFixtures;
import au.net.netstorm.boost.test.marker.LazyFields;
import au.net.netstorm.boost.util.type.Interface;

public final class DoesNotImplementFactoryExceptionAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
    DoesNotImplementFactoryException subject;
    Interface marker;
    Class cls;

    public void setUpFixtures() {
        subject = new DoesNotImplementFactoryException(cls, marker);
    }

    public void testException() {
        String actual = subject.getMessage();
        String expected = cls + " should implement " + marker;
        assertEquals(expected, actual);
    }
}
