package au.net.netstorm.boost.sniper.reflect.checker;

import au.net.netstorm.boost.gunge.type.Interface;

public interface ClassTestChecker {
    void checkImplementsAndFinal(Interface expectedInterface, Class implementationClass);

    void checkImplementsAndFinal(Class expectedInterface, Class implementationClass);

    void checkSubInterfaceOf(Interface subInterface, Interface superInterface);

    void checkSubclassOf(Class subClass, Class superClass);

    void checkSubclassOf(Class expectedImpl, Object ref);

    void checkSynchronized(Class cls);
}
