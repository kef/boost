package au.net.netstorm.boost.pebble.core;

import au.net.netstorm.boost.pebble.type.Implementation;
import au.net.netstorm.boost.test.automock.BoooostCase;
import au.net.netstorm.boost.util.type.Interface;

public final class IllegalCitizenExceptionAtomicTest extends BoooostCase {
    private Interface marker;
    private Implementation impl;

//    throw new IllegalStateException("I know you want to be my darling, but you're not a " + marker + " -> " + impl);

    // FIX 1715 Complete.

    public void testException() {
        RuntimeException ex = new IllegalCitizenException(marker, impl);
    }
}
