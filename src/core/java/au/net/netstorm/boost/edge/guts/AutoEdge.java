package au.net.netstorm.boost.edge.guts;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public interface AutoEdge extends InvocationHandler {
    Object invoke(Object edge, Method edgeMethod, Object[] edgedArgs);
}
