package au.net.netstorm.boost.reflect;

// FIXME: SC043 Extend EdgeException which extends RuntimeException

public final class EdgeClassNotFoundException extends RuntimeException {
    public EdgeClassNotFoundException(ClassNotFoundException e) {
        super(e);
    }
}
