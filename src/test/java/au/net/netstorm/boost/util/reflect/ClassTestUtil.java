/*
 * Copyright (C) 2005 Transtoll Pty Limited.
 */
package au.net.netstorm.boost.util.reflect;

import au.net.netstorm.boost.util.type.Interface;

// FIXME: SC042 There seems to be a distinct split into check* and is* methods.  Split.

public interface ClassTestUtil {
    boolean isInterface(Class cls);

    boolean isImplementationOf(Interface targetInterface, Class cls);

    boolean isSubclassOf(Class superClass, Class subclass);

    void checkFieldType(Class expectedClass, Object ref, String fieldName);

    void checkImplementationOfInterfaceAndFinal(Class targetInterface, Class implementationClass);

    void checkSubclassOf(Class superClass, Class subClass);

    void checkSubclassOf(Class expectedImpl, Object ref);
}
