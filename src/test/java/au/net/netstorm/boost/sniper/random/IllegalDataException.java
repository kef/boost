package au.net.netstorm.boost.sniper.random;

import au.net.netstorm.boost.bullet.primordial.PrimordialException;

public final class IllegalDataException extends PrimordialException {
    public IllegalDataException(String message, Class type) {
        super(message + ": " + type);
    }
}
