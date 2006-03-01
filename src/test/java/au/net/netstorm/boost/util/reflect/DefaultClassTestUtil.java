package au.net.netstorm.boost.util.reflect;

import au.net.netstorm.boost.util.type.Interface;
import junit.framework.Assert;

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

    public void checkImplementsAndFinal(Class expectedInterface, Class cls) {
        Interface iface = new Interface(expectedInterface);
        checkImplementsAndFinal(iface, cls);
    }

    public void checkImplementsAndFinal(Interface expectedInterface, Class cls) {
        modifier.checkFinal(cls);
        checkImplementsInterface(expectedInterface, cls);
    }

    public void checkSubclassOf(Class superClass, Class subClass) {
        boolean isSubclass = isSubclassOf(superClass, subClass);
        checkSubclassOf(isSubclass, superClass, subClass);
    }

    public void checkSubclassOf(Class superClass, Object ref) {
        Assert.assertNotNull(ref);
        Class cls = ref.getClass();
        checkSubclassOf(superClass, cls);
    }

    private void checkImplementsInterface(Interface iface, Class cls) {
        boolean implementsIt = isImplementationOf(iface, cls);
        checkImplementsInterface(implementsIt, iface, cls);
    }

    private void checkImplementsInterface(boolean implementsIt, Interface iface, Class cls) {
        String implName = getShortName(cls);
        String targetName = getShortName(iface);
        Assert.assertTrue(implName + " is not an implementation of " + targetName, implementsIt);
    }

    // FIXME: SC042 Moving getShortName into Class... will help here.  Requires TDing ClassMaster.
    private String getShortName(Interface iface) {
        Class cls = iface.getType();
        return getShortName(cls);
    }

    private void checkSubclassOf(boolean isSubclass, Class superClass, Class subClass) {
        String superClassName = getShortName(superClass);
        String subClassName = getShortName(subClass);
        Assert.assertTrue(subClassName + " is not a subclass of " + superClassName, isSubclass);
    }

    private String getShortName(Class cls) {
        return clsMaster.getShortName(cls);
    }
}
