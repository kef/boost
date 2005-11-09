package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

// FIXME: SC511 Map exception exactly how an "edge" should.

class DefaultReflectEdge implements ReflectEdge {
    public Object get(Field field, Object ref) {
        try {
            return field.get(ref);
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
            throw new RuntimeClassNotFoundException(e);
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
            method.setAccessible(true);  // FIXME: SC502 This should not be here.  It violates edge rules.
            return method.invoke(instance, args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
