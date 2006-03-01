package au.net.netstorm.boost.util.reflect;

import au.net.netstorm.boost.util.type.Interface;

// FIXME: SC042 Rename.

public class DefaultClassTestUtil implements ClassTestUtil {
    private final ModifierTestChecker modifier = new DefaultModifierTestChecker();
    private final ClassMaster clsMaster = new DefaultClassMaster();

    // FIXME: SC042 Investigate ... This did not appear to work for targetInterface == java.io.Serializable ?
    public boolean isImplementationOf(Interface targetInterface, Class cls) {
        Class type = targetInterface.getType();
        return type.isAssignableFrom(cls);
    }

    public boolean isSubclassOf(Class superClass, Class subclass) {
        return superClass.isAssignableFrom(subclass);
    }
}
