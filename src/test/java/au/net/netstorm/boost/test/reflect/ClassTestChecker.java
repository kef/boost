package au.net.netstorm.boost.test.reflect;

import au.net.netstorm.boost.util.type.Interface;

public interface ClassTestChecker {
    void checkImplementsAndFinal(Interface expectedInterface, Class cls);

    void checkImplementsAndFinal(Class targetInterface, Class implementationClass);

    void checkSubInterfaceOf(Interface superInterface, Interface subInterface);

    void checkSubclassOf(Class superClass, Class subClass);

    void checkSubclassOf(Class expectedImpl, Object ref);

    void checkSynchronized(Class cls);
}
