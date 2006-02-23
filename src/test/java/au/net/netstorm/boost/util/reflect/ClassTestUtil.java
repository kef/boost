/*
 * Copyright (C) 2005 Transtoll Pty Limited.
 */
package au.net.netstorm.boost.util.reflect;

import au.net.netstorm.boost.util.type.Interface;

// FIXME: SC042 There seems to be a distinct split into check* and is* methods.  Split.

public interface ClassTestUtil {
    boolean isAbstract(Class cls);

    boolean isFinal(Class cls);

    boolean isPublic(Class cls);

    boolean isInterface(Class cls);

    boolean isImplementationOf(Interface targetInterface, Class cls);

    boolean isSubclassOf(Class superClass, Class subclass);

    void checkSynchronized(Class type);

    void checkFieldType(Class expectedClass, Object ref, String fieldName);

    void checkImplementationOfInterfaceAndFinal(Class targetInterface, Class implementationClass);

    void checkSubclassOf(Class superClass, Class subClass);

    void checkClassFinal(Class cls);

    void checkClassPublic(Class cls);

    void checkSubclassOf(Class expectedImpl, Object ref);
}
