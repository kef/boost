/*
 * Copyright (C) 2005 Transtoll Pty Limited.
 */
package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Method;

public interface MethodTestUtil {
    boolean isPublic(Method method);

    Class getThrowsType(Method method);

    Class getRealExceptionClass(Throwable t); // FIXME: SC042 This belongs elsewhere (ExceptionTestUtil?).
}
