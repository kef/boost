package au.net.netstorm.boost.edge.java.lang.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class DefaultEdgeMethod implements EdgeMethod {
    // FIXME: SC523 Null checks?
    public Object invoke(Method method, Object obj, Object[] args) {
        try {
            return method.invoke(obj, args);
        } catch (InvocationTargetException e) {
            throw new EdgeInvocationTargetException(e);
        } catch (IllegalAccessException e) {
            // FIXME: SC523 Exception catch re-ordered to get around simian. HACK!!!
            throw new EdgeIllegalAccessException(e);
        }
    }
}
