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

    // FIXME: SC042 Hide?
    public void checkImplementsAndFinal(Class expectedInterface, Class cls) {
        modifier.checkFinal(cls);
        Interface iface = new Interface(expectedInterface);
        checkImplementsInterface(iface, cls);
    }

    // FIXME: SC042 Push up.
    public void checkImplementsAndFinal(Interface expectedInterface, Class cls) {
        // FIXME: SC042 Complete this.
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

    private String getShortName(Interface iface) {
        // FIXME: SC042 Moving getShortName into Class... will help here.
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
