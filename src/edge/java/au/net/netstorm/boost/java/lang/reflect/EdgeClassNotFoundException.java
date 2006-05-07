package au.net.netstorm.boost.java.lang.reflect;

import au.net.netstorm.boost.edge.EdgeException;

public final class EdgeClassNotFoundException extends EdgeException {
    public EdgeClassNotFoundException(ClassNotFoundException e) {
        super(e);
    }
}
