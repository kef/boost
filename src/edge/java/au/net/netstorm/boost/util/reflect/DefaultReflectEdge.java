package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

// FIXME: SC501 Map exception exactly how an "edge" should.
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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Class forName(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Method getMethod(Class cls, String methodName, Class[] parameterTypes) {
        try {
            return cls.getMethod(methodName, parameterTypes);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public Object invoke(Method method, Object instance) throws Exception {
        return invoke(method, instance, null);
    }

    public Object invoke(Method method, Object instance, Object[] args) throws Exception {
        method.setAccessible(true);
        return method.invoke(instance, args);
    }

    public Object tryInvoke(Method method, Object instance) {
        try {
            return invoke(method, instance);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Object tryInvoke(Method method, Object instance, Object[] args) {
        try {
            return invoke(method, instance, args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
