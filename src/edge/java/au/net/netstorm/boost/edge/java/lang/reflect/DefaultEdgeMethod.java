package au.net.netstorm.boost.edge.java.lang.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import au.net.netstorm.boost.edge.EdgeException;

public final class DefaultEdgeMethod implements EdgeMethod {
    public Object invoke(Method method, Object obj, Object[] args) {
        try {
            return method.invoke(obj, args);
        } catch (InvocationTargetException e) {
            throw new EdgeException(e);
        } catch (IllegalAccessException e) {
            // FIX SC523 Exception catch re-ordered to get around simian. HACK!!!
            throw new EdgeException(e);
        }
    }
}
