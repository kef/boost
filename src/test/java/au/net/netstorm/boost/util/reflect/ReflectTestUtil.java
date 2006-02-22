/*
 * Copyright (C) 2005 Transtoll Pty Limited.
 */
package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Field;

public interface ReflectTestUtil {
    Class getException(Method method);

    Object getStaticFieldValue(Class cls, String fieldName);

    Object getInstanceFieldValue(Object ref, String fieldName);

    Field getDeclaredField(Class cls, String fieldName);

    void setInstanceFieldValue(Object ref, String fieldName, Object fieldValue);

    void setStaticFieldValue(Class cls, String fieldName, Object fieldValue);

    void checkPrivateFinalField(Class type, String fieldName);

    boolean methodIsPublic(Method method);

    Class getRealExceptionClass(RuntimeException e);
}
