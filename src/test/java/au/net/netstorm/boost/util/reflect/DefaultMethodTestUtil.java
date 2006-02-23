/*
 * Copyright (C) 2005 Transtoll Pty Limited.
 */
package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import junit.framework.Assert;

public class DefaultMethodTestUtil implements MethodTestUtil {
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
