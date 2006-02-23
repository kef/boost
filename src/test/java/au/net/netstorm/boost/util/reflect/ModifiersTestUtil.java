/*
 * Copyright (C) 2005 Transtoll Pty Limited.
 */
package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Method;

public interface ModifiersTestUtil {
    boolean isPublic(Method method);

    boolean isFinal(Method method);

    boolean isPublicInstance(Method method);

    boolean isAbstract(Class cls);

    boolean isFinal(Class cls);

    boolean isPublic(Class cls);

    // FIXME: SC042 These loook out of place.  Do they really belong here? If they do, make things symmetric.

    void checkFinal(Class cls);

    void checkPublic(Class cls);

    void checkSynchronized(Class cls);
}
