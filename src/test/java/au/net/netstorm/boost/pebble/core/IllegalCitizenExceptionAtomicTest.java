package au.net.netstorm.boost.pebble.core;

import au.net.netstorm.boost.pebble.type.Implementation;
import au.net.netstorm.boost.test.automock.BoooostCase;
import au.net.netstorm.boost.util.type.Interface;

public final class IllegalCitizenExceptionAtomicTest extends BoooostCase {
    private RuntimeException subject;
    private Interface marker;
    private Implementation impl;

    public void setupSubjects() {
        subject = new IllegalCitizenException(marker, impl);
    }

    // FIX 1715 Complete.

    // FIX BREADCRUMB 1715 Return and complete.

    public void testException() {
        setupSubjects();
//        assertEquals("I know you want to be my darling, but you're not a " + marker + " -> " + impl, "" + subject);
    }
}
