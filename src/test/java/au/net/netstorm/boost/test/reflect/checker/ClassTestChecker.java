package au.net.netstorm.boost.test.reflect.checker;

import au.net.netstorm.boost.util.type.Interface;

public interface ClassTestChecker {
    void checkImplementsAndFinal(Interface expectedInterface, Class cls);

    void checkImplementsAndFinal(Class implementationClass, Class targetInterface);

    void checkSubInterfaceOf(Interface superInterface, Interface subInterface);

    void checkSubclassOf(Class subClass, Class superClass);

    void checkSubclassOf(Class expectedImpl, Object ref);

    void checkSynchronized(Class cls);
}
