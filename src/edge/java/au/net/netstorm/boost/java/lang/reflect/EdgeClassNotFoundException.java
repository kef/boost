package au.net.netstorm.boost.java.lang.reflect;

import au.net.netstorm.boost.misc.EdgeException;

public final class EdgeClassNotFoundException extends EdgeException {
    public EdgeClassNotFoundException(ClassNotFoundException e) {
        super(e);
    }
}
