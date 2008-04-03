package au.net.netstorm.boost.gunge.random;

import au.net.netstorm.boost.primordial.PrimordialException;

public final class IllegalDataException extends PrimordialException {
    public IllegalDataException(String message, Class type) {
        super(message + ": " + type);
    }
}
