package au.net.netstorm.boost.sledge.java.lang.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import au.net.netstorm.boost.sledge.support.EdgeException;

// FIX 2328 Rename all au.net.netstorm.boost.edge.* to au.net.netstorm.boost.edge.stateless
public final class DefaultEdgeMethod implements EdgeMethod {
    public Object invoke(Method method, Object obj, Object[] args) {
        try {
            return method.invoke(obj, args);
        } catch (IllegalAccessException e) {
            throw new EdgeException(e);
        } catch (InvocationTargetException e) {
            throw new EdgeException(e);
        }
    }
}
