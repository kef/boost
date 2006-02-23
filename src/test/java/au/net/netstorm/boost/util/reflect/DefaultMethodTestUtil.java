/*
 * Copyright (C) 2005 Transtoll Pty Limited.
 */
package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import junit.framework.Assert;

public class DefaultMethodTestUtil implements MethodTestUtil {
    private final ReflectEdge edge = ReflectEdge.INSTANCE;

    // FIXME: SC042 Tidy ordering et al up.
    public Object invoke(Object invokee, String methodName, Object[] parameters) {
        Method method = getMethod(invokee, methodName);
        return invoke(invokee, method, parameters);
    }

    private Method getMethod(Object instance, String methodName) {
        Class type = instance.getClass();
        return getMethod(type, methodName);
    }

    private Method getMethod(Class type, String methodName) {
        Method[] methods = type.getMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            if (matches(method, methodName)) return method;
        }
        throw new IllegalStateException("No method " + methodName + " on " + type);
    }

    private Object invoke(Object invokee, Method method, Object[] parameters) {
        return edge.invoke(method, invokee, parameters);
    }

    private boolean matches(Method method, String methodName) {
        String name = method.getName();
        return name.equals(methodName);
    }

    public Class getThrowsType(Method method) {
        Class[] exceptions = method.getExceptionTypes();
        String name = method.getName();
        Assert.assertTrue(name + "() must throw a single exception.", exceptions.length == 1);
        return exceptions[0];
    }

    public boolean isPublic(Method method) {
        int modifiers = method.getModifiers();
        return Modifier.isPublic(modifiers);
    }

    public Class getRealExceptionClass(Throwable t) {
        // FIXME: SC050 This certainly does not really work.  Sort this out!!!
        // FIXME: SC042 Early returns fellas.
        Throwable realException = t;
        if (realException.getClass() == RuntimeException.class) realException = (Throwable) realException.getCause();
        if (realException.getClass() == InvocationTargetException.class)
            realException = (Throwable) realException.getCause();
        return realException.getClass();
    }
}
