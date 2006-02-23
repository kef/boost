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

    // FIXME: SC042 These loook out of place.  Do they really belong here?
    // FIXME: SC042 If they do, make things symmetric.

    // FIXME: SC042 Drop the Class from the method name.
    void checkClassFinal(Class cls);

    // FIXME: SC042 Drop the Class from the method name.
    void checkClassPublic(Class cls);

    // FIXME: SC042 This is a modifier too (right?).
    void checkSynchronized(Class type);
}
