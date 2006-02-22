/*
 * Copyright (C) 2005 Transtoll Pty Limited.
 */
package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Field;

public interface ReflectTestUtil {
    Class getException(Method method);

    Object getStaticField(Class cls, String fieldName);

    Object getInstanceField(Object ref, String fieldName);

    Field getDeclaredField(Class cls, String fieldName);

    void setInstanceField(Object ref, String fieldName, Object fieldValue);

    void setStaticField(Class cls, String fieldName, Object fieldValue);

    void checkPrivateFinalField(Class type, String fieldName);

    boolean methodIsPublic(Method method);

    Class getRealExceptionClass(RuntimeException e);
}
