package au.net.netstorm.boost.test.checker;

import au.net.netstorm.boost.util.type.Interface;

// FIX SC525 All the checkers should be moved into "reflect.check".  Existing "reflect" stuff should go into "reflect.util"

public interface ClassTestChecker {
    void checkImplementsAndFinal(Interface expectedInterface, Class cls);

    void checkImplementsAndFinal(Class targetInterface, Class implementationClass);

    void checkSubInterfaceOf(Interface superInterface, Interface subInterface);

    void checkSubclassOf(Class superClass, Class subClass);

    void checkSubclassOf(Class expectedImpl, Object ref);

    void checkSynchronized(Class cls);
}
