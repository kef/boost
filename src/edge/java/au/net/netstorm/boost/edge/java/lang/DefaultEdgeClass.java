package au.net.netstorm.boost.edge.java.lang;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import au.net.netstorm.boost.edge.EdgeException;// FIXME: SC600 Complete this.
// FIXME: SC600 Move into java.lang (Similar to Class).

public final class DefaultEdgeClass implements EdgeClass {
    private final Class cls;

    public DefaultEdgeClass(Class cls) {
        this.cls = cls;
    }

    public Object newInstance() {
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            throw new EdgeException(e);
        } catch (IllegalAccessException e) {
            throw new EdgeException(e);
        }
    }

    // FIX SC600 Added these to fix build. Whoever knows about these should implement or remove them.
    public Method getMethod(String methodName, Class[] parameterTypes) {
        throw new UnsupportedOperationException();
    }

    public Field getDeclaredField(String fieldName) {
        throw new UnsupportedOperationException();
    }
}
