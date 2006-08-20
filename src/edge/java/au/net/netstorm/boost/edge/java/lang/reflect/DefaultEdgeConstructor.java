package au.net.netstorm.boost.edge.java.lang.reflect;

import au.net.netstorm.boost.edge.EdgeException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class DefaultEdgeConstructor implements EdgeConstructor {
    public Object newInstance(Constructor constructor, Object[] initArgs) {
        try {
            return constructor.newInstance(initArgs);
        } catch (InstantiationException e) {
            throw new EdgeException(e);
        } catch (IllegalAccessException e) {
            throw new EdgeException(e);
        } catch (InvocationTargetException e) {
            throw new EdgeException(e);
        }
    }
}
