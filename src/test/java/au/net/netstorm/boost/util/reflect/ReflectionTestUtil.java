/*
 * Copyright (C) 2005 Transtoll Pty Limited.
 */
package au.net.netstorm.boost.util.reflect;

public interface ReflectionTestUtil {
    Object invoke(Object invokee, String methodName, Object[] parameters);
}
