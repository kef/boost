/*
 * Copyright (C) 2005 Transtoll Pty Limited.
 */
package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Method;

import au.net.netstorm.boost.util.type.Interface;

public interface ClassPropertiesTestUtil {
    boolean isPublicInstance(Method method);

    // FIXME: SC042 Rename to isAbstract.  Same for below.
    boolean isAbstract(Class cls);

    boolean isFinal(Class cls);

    boolean isPublic(Class cls);

    boolean isInterface(Class cls);

    boolean isImplementationOf(Interface targetInterface, Class cls);

    boolean isSubclassOf(Class superClass, Class subclass);

    boolean isFinal(Method method);

    // FIXME: SC042 - Complete tidy up of ReflectTestUtil.  Look for all new ReflectTestUtil instances.
    void checkFieldType(Class expectedClass, Object ref, String fieldName);

    void checkImplementationOfInterfaceAndFinal(Class targetInterface, Class implementationClass);

    void checkSubclassOf(Class superClass, Class subClass);

    void checkClassFinal(Class cls);

    void checkClassPublic(Class cls);

    void checkInstance(Class expectedImpl, Object ref);
}
