package au.net.netstorm.boost.sniper.reflect.checker;

import java.lang.reflect.Method;
import au.net.netstorm.boost.bullet.mirror.ClassMaster;
import au.net.netstorm.boost.bullet.mirror.DefaultClassMaster;
import au.net.netstorm.boost.gunge.type.DefaultInterface;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.sniper.reflect.util.ClassTestUtil;
import au.net.netstorm.boost.sniper.reflect.util.DefaultClassTestUtil;
import junit.framework.Assert;

// FIX SC600 reorder these.

// FIX SC600 remove dupe.
public final class DefaultClassTestChecker implements ClassTestChecker {
    private static final String[] EXCLUSIONS = {"hashCode", "getClass", "equals", "toString", "wait", "notify", "notifyAll"};
    private final ModifierTestChecker modifier = new DefaultModifierTestChecker();
    private final ClassTestUtil classes = new DefaultClassTestUtil();
    private final ClassMaster clsMaster = new DefaultClassMaster();

    public void checkImplementsAndFinal(Interface expectedInterface, Class cls) {
        modifier.checkFinal(cls);
        checkImplementsInterface(expectedInterface, cls);
    }

    public void checkImplementsAndFinal(Class expectedInterface, Class cls) {
        Interface iface = new DefaultInterface(expectedInterface);
        checkImplementsAndFinal(iface, cls);
    }

    public void checkSubInterfaceOf(Interface subInterface, Interface superInterface) {
        boolean isSubInterface = classes.isSubInterfaceOf(superInterface, subInterface);
        Assert.assertTrue(subInterface + " is not subinterface of  " + superInterface + ".", isSubInterface);
    }

    public void checkSubclassOf(Class subClass, Class superClass) {
        boolean isSubclass = classes.isSubclassOf(superClass, subClass);
        checkSubclassOf(isSubclass, superClass, subClass);
    }

    public void checkSubclassOf(Class superClass, Object ref) {
        Assert.assertNotNull(ref);
        Class cls = ref.getClass();
        checkSubclassOf(cls, superClass);
    }

    public void checkSynchronized(Class cls) {
        Method[] methods = cls.getMethods();
        for (int i = 0; i < methods.length; i++) {
            checkSynchronizedIgnoringExclusions(methods[i]);
        }
    }

    private void checkSubclassOf(boolean isSubclass, Class superClass, Class subClass) {
        String superClassName = getShortName(superClass);
        String subClassName = getShortName(subClass);
        Assert.assertTrue(subClassName + " is not a subclass of " + superClassName + ".", isSubclass);
    }

    private void checkImplementsInterface(Interface iface, Class cls) {
        boolean implementsIt = classes.isImplementationOf(iface, cls);
        checkImplementsInterface(implementsIt, iface, cls);
    }

    private void checkImplementsInterface(boolean implementsIt, Interface iface, Class cls) {
        String implName = getShortName(cls);
        String targetName = getShortName(iface);
        Assert.assertTrue(implName + " is not an implementation of " + targetName + ".", implementsIt);
    }

    private void checkSynchronizedIgnoringExclusions(Method method) {
        boolean isExclusion = isExclusion(method);
        if (isExclusion) return;
        modifier.checkSynchronized(method);
    }

    private boolean isExclusion(Method method) {
        String name = method.getName();
        return isExclusion(name);
    }

    private boolean isExclusion(String methodName) {
        for (int i = 0; i < EXCLUSIONS.length; i++) {
            if (methodName.equals(EXCLUSIONS[i])) return true;
        }
        return false;
    }

    private String getShortName(Interface iface) {
        return clsMaster.getShortName(iface);
    }

    private String getShortName(Class cls) {
        return clsMaster.getShortName(cls);
    }
}
