package au.net.netstorm.boost.util.impl;

import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.Interface;

public final class NoImplementationExceptionAtomicTest extends InteractionTestCase implements HasFixtures {
    NoImplementationException subject;
    Interface iface;

    public void setUpFixtures() {
        subject = new NoImplementationException(iface);
    }

    public void testMessage() {
        String actual = subject.getMessage();
        String expected = "No implementation for " + iface;
        assertEquals(expected, actual);
    }
}