package au.net.netstorm.boost.nursery.autoedge;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

interface AutoEdge extends InvocationHandler {
    Object invoke(Object edge, Method edgeMethod, Object[] edgedArgs);
}
