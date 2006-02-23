/*
 * Copyright (C) 2005 Transtoll Pty Limited.
 */
package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Method;

public interface ReflectionTestUtil {
    Method getMethod(Object instance, String methodName);

    Method getMethod(Class type, String methodName);

    Object invoke(Object invokee, String methodName, Object[] parameters);
}
