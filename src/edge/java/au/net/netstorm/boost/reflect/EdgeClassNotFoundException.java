package au.net.netstorm.boost.reflect;

// FIXME: SC502 Atomic test.

public final class EdgeClassNotFoundException extends RuntimeException {
    public EdgeClassNotFoundException(ClassNotFoundException e) {
        super(e);
    }
}
