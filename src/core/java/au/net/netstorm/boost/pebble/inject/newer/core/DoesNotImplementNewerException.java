package au.net.netstorm.boost.pebble.inject.newer.core;

import au.net.netstorm.boost.primordial.PrimordialException;
import au.net.netstorm.boost.util.type.Interface;

public final class DoesNotImplementNewerException extends PrimordialException {

    public DoesNotImplementNewerException(Interface type, Interface marker) {
        // FIX 35820 Sort this out.  Must toString() actual types.
        super("type should implement marker");
    }
}
