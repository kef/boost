package au.net.netstorm.boost.edge.java.lang;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import au.net.netstorm.boost.edge.EdgeException;

public final class DefaultEdgeClass implements EdgeClass {
    public Class forName(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new EdgeException(e);
        }
    }

    public Object newInstance(Class cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            throw new EdgeException(e);
        } catch (IllegalAccessException e) {
            throw new EdgeException(e);
        }
    }

    public Method getMethod(Class cls, String methodName, Class[] parameterTypes) {
        try {
            return cls.getMethod(methodName, parameterTypes);
        } catch (NoSuchMethodException e) {
            throw new EdgeException(e);
        }
    }

    public Field getDeclaredField(Class cls, String fieldName) {
        try {
            return cls.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            throw new EdgeException(e);
        }
    }
}
