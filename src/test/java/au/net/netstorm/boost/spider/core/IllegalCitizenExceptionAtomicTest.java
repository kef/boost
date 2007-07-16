package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.primordial.BoooostException;
import au.net.netstorm.boost.test.automock.HasFixtures;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.test.automock.LazyFields;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class IllegalCitizenExceptionAtomicTest extends InteractionTestCase implements HasFixtures, LazyFields {
    BoooostException subject;
    Interface marker;
    Implementation impl;

    public void setUpFixtures() {
        subject = new IllegalCitizenException(marker, impl);
    }

    public void testException() {
        String result = subject.getMessage();
        assertEquals("I know you want to be my darling,... \nbut you're not a " + marker + " -> " + impl, result);
    }
}
