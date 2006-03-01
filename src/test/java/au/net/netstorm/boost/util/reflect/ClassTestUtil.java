package au.net.netstorm.boost.util.reflect;

import au.net.netstorm.boost.util.type.Interface;

public interface ClassTestUtil {
    boolean isImplementationOf(Interface targetInterface, Class cls);

    boolean isSubclassOf(Class superClass, Class subclass);
}
