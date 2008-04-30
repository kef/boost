package au.net.netstorm.boost.edge.java.lang.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import au.net.netstorm.boost.edge.EdgeException;

public final class DefaultEdgeMethod implements EdgeMethod {
    public Object invoke(Method method, Object obj, Object[] args) {
        try {
            return method.invoke(obj, args);
        } catch (IllegalAccessException e) {
            throw new EdgeException(e);
        } catch (InvocationTargetException e) {
            // FIX 2328 Discuss this with the crew.
            // SUGGEST e.getTargetException(), maybe even check if target exception
            //         is a runtime exception and don't wrap for that case
            throw new EdgeException(e);
        }
    }
}
