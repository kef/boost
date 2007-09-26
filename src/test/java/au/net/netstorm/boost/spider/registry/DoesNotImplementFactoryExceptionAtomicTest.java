package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.Interface;

public final class DoesNotImplementFactoryExceptionAtomicTest extends InteractionTestCase implements HasFixtures {
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
