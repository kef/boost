package au.net.netstorm.boost.util.reflect;

import au.net.netstorm.boost.util.type.Interface;

// FIXME: SC042 There seems to be a distinct split into check* and is* methods.  Split.
// FIXME: SC042 Split into checker.

public interface ClassTestUtil {
    boolean isImplementationOf(Interface targetInterface, Class cls);

    boolean isSubclassOf(Class superClass, Class subclass);
}
