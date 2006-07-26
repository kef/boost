package au.net.netstorm.boost.edge.java.lang.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class DefaultEdgeConstructor implements EdgeConstructor {
    // FIXME: SC523 Null checks.
    public Object newInstance(Constructor constructor, Object[] initArgs) {
        try {
            return constructor.newInstance(initArgs);
        } catch (InstantiationException e) {
            throw new EdgeInstantiationException(e);
        } catch (IllegalAccessException e) {
            throw new EdgeIllegalAccessException(e);
        } catch (InvocationTargetException e) {
            throw new EdgeInvocationTargetException(e);
        }
    }
}
