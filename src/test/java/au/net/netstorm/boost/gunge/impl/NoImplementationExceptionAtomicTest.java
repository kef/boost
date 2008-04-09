package au.net.netstorm.boost.gunge.impl;

import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.LazyFields;

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