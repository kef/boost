package au.net.netstorm.boost.sledge.java.lang.reflect;

import java.lang.reflect.Constructor;
import au.net.netstorm.boost.sledge.support.EdgeException;

public final class DefaultEdgeConstructor implements EdgeConstructor {
    public <T> T newInstance(Constructor<T> constructor, Object[] args) {
        try {
            return constructor.newInstance(args);
        } catch (Exception e) {
            throw new EdgeException(e);
        }
    }
}

