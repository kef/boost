package au.net.netstorm.boost.util.impl;

import au.net.netstorm.boost.gunge.core.LifecycleTestCase;
import au.net.netstorm.boost.gunge.marker.HasFixtures;
import au.net.netstorm.boost.gunge.marker.LazyFields;
import au.net.netstorm.boost.util.type.Interface;

public final class NoImplementationExceptionAtomicTest extends LifecycleTestCase implements HasFixtures, LazyFields {
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