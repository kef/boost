package au.net.netstorm.boost.edge.java.lang.reflect;

import au.net.netstorm.boost.edge.EdgeException;

public final class EdgeIllegalAccessException extends EdgeException {
    public EdgeIllegalAccessException(IllegalAccessException e) {
        super(e);
    }
}
