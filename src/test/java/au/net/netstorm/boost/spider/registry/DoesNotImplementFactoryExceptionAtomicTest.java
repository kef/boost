package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;

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
