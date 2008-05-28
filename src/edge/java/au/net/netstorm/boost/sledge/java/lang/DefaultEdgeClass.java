package au.net.netstorm.boost.sledge.java.lang;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import au.net.netstorm.boost.sledge.support.EdgeException;

public final class DefaultEdgeClass implements EdgeClass {
    public Class forName(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new EdgeException(e);
        }
    }

    public <T> T newInstance(Class<? extends T> cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            throw new EdgeException(e);
        } catch (IllegalAccessException e) {
            throw new EdgeException(e);
        }
    }

    public <T> Constructor<T> getConstructor(Class<T> cls, Class<?>... parameterTypes) {
        try {
            return cls.getConstructor(parameterTypes);
        } catch (NoSuchMethodException e) {
            throw new EdgeException(e);
        }
    }

    public Method getMethod(Class cls, String methodName, Class... parameterTypes) {
        try {
            return cls.getMethod(methodName, parameterTypes);
        } catch (NoSuchMethodException e) {
            throw new EdgeException(e);
        }
    }

    public Method getDeclaredMethod(Class cls, String methodName, Class... parameterTypes) {
        try {
            return cls.getDeclaredMethod(methodName, parameterTypes);
        } catch (NoSuchMethodException e) {
            throw new EdgeException(e);
        }
    }

    public Field getDeclaredField(Class cls, String fieldName) {
        try {
            return cls.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            throw barf(cls, fieldName, e);
        }
    }

    public Field getField(Class cls, String fieldName) {
        try {
            return cls.getField(fieldName);
        } catch (NoSuchFieldException e) {
            throw barf(cls, fieldName, e);
        }
    }

    public Field[] getDeclaredFields(Class cls) {
        return cls.getDeclaredFields();
    }

    private EdgeException barf(Class cls, String fieldName, NoSuchFieldException e) {
        String name = cls.getName();
        return new EdgeException("There is no such field called \"" + fieldName + "\" in class " + name, e);
    }
}
