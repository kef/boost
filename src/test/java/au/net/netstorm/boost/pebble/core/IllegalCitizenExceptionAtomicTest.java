package au.net.netstorm.boost.pebble.core;

import au.net.netstorm.boost.pebble.type.Implementation;
import au.net.netstorm.boost.test.automock.InteractionTestCase;
import au.net.netstorm.boost.util.type.Interface;

public final class IllegalCitizenExceptionAtomicTest extends InteractionTestCase {
    private BoostException subject;
    private Interface marker;
    private Implementation impl;

    public void setupSubjects() {
        subject = new IllegalCitizenException(marker, impl);
    }

    // FIX 1715 Complete.

    // FIX BREADCRUMB 1715 Return and complete.

    public void testException() {
//        assertEquals("I know you want to be my darling, but you're not a " + marker + " -> " + impl, "" + subject);
    }
}
