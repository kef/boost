package au.net.netstorm.boost.pebble.core;

// FIX BREADCRUMB 1715 Move to appropriate package.

// FIX 1715 Atomically test.
public class PrimordialException extends RuntimeException implements BoostException {
    public PrimordialException(String string) {
        super(string);
    }
}
