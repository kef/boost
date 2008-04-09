package au.net.netstorm.boost.sniper.reflect.util;

import au.net.netstorm.boost.util.type.Interface;

public interface ClassTestUtil {
    boolean isImplementationOf(Interface targetInterface, Class cls);

    boolean isSubclassOf(Class superClass, Class subClass);

    Object newInstance(Class type);

    boolean isSubInterfaceOf(Interface superInterface, Interface subInterface);
}
