package au.net.netstorm.boost.pebble.core;

import au.net.netstorm.boost.pebble.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class IllegalCitizenException extends PrimordialException {
    public IllegalCitizenException(Interface marker, Implementation impl) {
        super("I know you want to be my darling, but you're not a " + marker + " -> " + impl);
    }
}