package au.net.netstorm.boost.pebble.core;

import au.net.netstorm.boost.pebble.type.Implementation;
import au.net.netstorm.boost.primordial.BoostException;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.Interface;

public final class IllegalCitizenExceptionAtomicTest extends InteractionTestCase {
    private BoostException subject;
    private Interface marker;
    private Implementation impl;

    public void setupSubjects() {
        subject = new IllegalCitizenException(marker, impl);
    }

    public void testException() {
        String result = subject.getMessage();
        assertEquals("I know you want to be my darling, but you're not a " + marker + " -> " + impl, result);
    }
}
