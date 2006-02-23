/*
 * Copyright (C) 2005 Transtoll Pty Limited.
 */
package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

// FIXME: SC042 In fact this mostly smells like a FieldTestUtil.

public interface ReflectTestUtil {
    // FIXME: SC042 Rename.
    Class getExceptionType(Method method);

    Object getStaticField(Class cls, String fieldName);

    Object getInstanceField(Object ref, String fieldName);

    Field getDeclaredField(Class cls, String fieldName);

    void setInstanceField(Object ref, String fieldName, Object fieldValue);

    void setStaticField(Class cls, String fieldName, Object fieldValue);

    void checkPrivateFinalField(Class type, String fieldName); // FIXME: SC042 This "check*" does not seem to fit here.

    boolean isPublic(Method method);

    Class getRealExceptionClass(RuntimeException e);
}
