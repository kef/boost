package au.net.netstorm.boost.edge.java.lang.reflect;

import java.lang.reflect.InvocationTargetException;

import au.net.netstorm.boost.edge.EdgeException;

public final class EdgeInvocationTargetException extends EdgeException {
    public EdgeInvocationTargetException(InvocationTargetException e) {
        super(e);
    }
}
