package au.net.netstorm.boost.edge.java.lang.reflect;

import au.net.netstorm.boost.edge.EdgeException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
