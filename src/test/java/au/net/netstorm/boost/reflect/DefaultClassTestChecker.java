package au.net.netstorm.boost.reflect;

import java.lang.reflect.Method;

import au.net.netstorm.boost.util.type.Interface;
import junit.framework.Assert;

// FIXME: SC521 reorder these.

public final class DefaultClassTestChecker implements ClassTestChecker {
    private static final String[] EXCLUSIONS = {"hashCode", "getClass", "equals", "toString", "wait", "notify", "notifyAll"};
    private final ModifierTestChecker modifier = new DefaultModifierTestChecker();
    private final ClassTestUtil classes = new DefaultClassTestUtil();
    private final ClassMaster clsMaster = new DefaultClassMaster();

    public void checkImplementsAndFinal(Class expectedInterface, Class cls) {
        Interface iface = new Interface(expectedInterface);
        checkImplementsAndFinal(iface, cls);
    }

    public void checkSubInterfaceOf(Interface superInterface, Interface subInterface) {
        boolean isSubInterface = classes.isSubInterfaceOf(superInterface, subInterface);
        Assert.assertTrue(subInterface + " is not subinterface of  " + superInterface, isSubInterface);
    }

    public void checkImplementsAndFinal(Interface expectedInterface, Class cls) {
        modifier.checkFinal(cls);
        checkImplementsInterface(expectedInterface, cls);
    }

    public void checkSubclassOf(Class superClass, Class subClass) {
        boolean isSubclass = classes.isSubclassOf(superClass, subClass);
        checkSubclassOf(isSubclass, superClass, subClass);
    }

    public void checkSubclassOf(Class superClass, Object ref) {
        Assert.assertNotNull(ref);
        Class cls = ref.getClass();
        checkSubclassOf(superClass, cls);
    }

    private void checkImplementsInterface(Interface iface, Class cls) {
        boolean implementsIt = classes.isImplementationOf(iface, cls);
        checkImplementsInterface(implementsIt, iface, cls);
    }

    private void checkSubclassOf(boolean isSubclass, Class superClass, Class subClass) {
        String superClassName = getShortName(superClass);
        String subClassName = getShortName(subClass);
        Assert.assertTrue(subClassName + " is not a subclass of " + superClassName, isSubclass);
    }

    private void checkImplementsInterface(boolean implementsIt, Interface iface, Class cls) {
        String implName = getShortName(cls);
        String targetName = getShortName(iface);
        Assert.assertTrue(implName + " is not an implementation of " + targetName, implementsIt);
    }

    public void checkSynchronized(Class cls) {
        Method[] methods = cls.getMethods();
        for (int i = 0; i < methods.length; i++) {
            checkSynchronizedIgnoringExclusions(methods[i]);
        }
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
