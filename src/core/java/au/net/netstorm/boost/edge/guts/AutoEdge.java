package au.net.netstorm.boost.edge.guts;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// FIX 2328 Split this package so the goodness is clear in "core".
public interface AutoEdge extends InvocationHandler {
    Object invoke(Object edge, Method edgeMethod, Object[] edgedArgs);
}
