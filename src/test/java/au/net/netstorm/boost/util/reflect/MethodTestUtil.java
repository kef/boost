/*
 * Copyright (C) 2005 Transtoll Pty Limited.
 */
package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Method;

public interface MethodTestUtil {
    // FIXME: SC042 Move these out into a separate class.
    boolean isPublic(Method method);

    Class getRealExceptionClass(RuntimeException e);

    Class getExceptionType(Method method);
}
