/*
 * Copyright (C) 2005 Transtoll Pty Limited.
 */
package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public interface MethodTestUtil {
    // FIXME: SC042 Remove field from all methods names.
    Object getStaticField(Class cls, String fieldName);

    Object getInstanceField(Object ref, String fieldName);

    Field getDeclaredField(Class cls, String fieldName);

    void setInstanceField(Object ref, String fieldName, Object fieldValue);

    void setStaticField(Class cls, String fieldName, Object fieldValue);

    void checkPrivateFinalField(Class type, String fieldName); // FIXME: SC042 This "check*" does not seem to fit here.

// FIXME: SC042 REMOVE ABOVE...    

    // FIXME: SC042 Move these out into a separate class.
    boolean isPublic(Method method);

    Class getRealExceptionClass(RuntimeException e);

    Class getExceptionType(Method method);
}
