package au.net.netstorm.boost.reflect;

import au.net.netstorm.boost.misc.EdgeException;

// FIXME: SC043 Extend EdgeException which extends RuntimeException

public final class EdgeClassNotFoundException extends EdgeException {
    public EdgeClassNotFoundException(ClassNotFoundException e) {
        super(e);
    }
}
