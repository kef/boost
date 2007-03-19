package au.net.netstorm.boost.primordial;

import au.net.netstorm.boost.pebble.core.BoostException;

// FIX 1715 Atomically test.
public class PrimordialException extends RuntimeException implements BoostException {
    public PrimordialException(String string) {
        super(string);
    }
}
