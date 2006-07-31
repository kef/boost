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

    public Method getMethod(String methodName, Class[] parameterTypes) {
        try {
            return cls.getMethod(methodName, parameterTypes);
        } catch (NoSuchMethodException e) {
            throw new EdgeException(e);
        }
    }

    public Field getDeclaredField(String fieldName) {
        try {
            return cls.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            throw new EdgeException(e);
        }
    }

    public Class getNonEdge() {
        return cls;
    }
}
