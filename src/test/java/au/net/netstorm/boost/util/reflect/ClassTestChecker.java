package au.net.netstorm.boost.util.reflect;

import au.net.netstorm.boost.util.type.Interface;

public interface ClassTestChecker {
    void checkImplementsAndFinal(Class targetInterface, Class implementationClass);

    void checkSubclassOf(Class superClass, Class subClass);

    void checkSubclassOf(Class expectedImpl, Object ref);

    void checkImplementsAndFinal(Interface expectedInterface, Class cls);
}
