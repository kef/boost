package au.net.netstorm.boost.edge.java.lang.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import au.net.netstorm.boost.edge.EdgeException;

public class DefaultEdgeReflect implements EdgeReflect {
    // FIXME: SC523 Throw edge exceptions.
    public Object getFieldValue(Field field, Object ref) {
        try {
            return field.get(ref);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    // FIXME: SC523 Throw edge exceptions.
    public void setFieldValue(Field field, Object ref, Object value) {
        try {
            field.set(ref, value);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    // FIXME: SC523 Throw edge exceptions.
    public Field getDeclaredField(Class cls, String fieldName) {
        try {
            return cls.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    // FIXME: SC523 Throw edge exceptions.
    public Object newInstance(Class cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public Object newInstance(Constructor constructor, Object[] parameters) {
        try {
            return constructor.newInstance(parameters);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public Class forName(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new EdgeException(e);
        }
    }

    public Method getMethod(Class cls, String methodName, Class[] parameterTypes) {
        try {
            return cls.getMethod(methodName, parameterTypes);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public Object invoke(Method method, Object instance) {
        return invoke(method, instance, null);
    }

    public Object invoke(Method method, Object instance, Object[] args) {
        try {
            return method.invoke(instance, args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
