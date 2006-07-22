package au.net.netstorm.boost.java.lang.reflect;

import au.net.netstorm.boost.edge.EdgeException;

public final class EdgeInstantiationException extends EdgeException {
    public EdgeInstantiationException(InstantiationException e) {
        super(e);
    }
}
