package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Modifier;

import au.net.netstorm.boost.util.type.Interface;
import junit.framework.Assert;

// FIXME: SC042 Rename.

public class DefaultClassTestUtil implements ClassTestUtil {
    private final ModifiersTestUtil modifiers = new DefaultModifiersTestUtil();
    private final FieldTestUtil reflector = new DefaultFieldTestUtil();
    private final ClassMaster clsMaster = new DefaultClassMaster();

    public boolean isInterface(Class cls) {
        int modifiers = cls.getModifiers();
        return isInterface(modifiers);
    }

    // FIXME: SC042 Investigate ... This did not appear to work for targetInterface == java.io.Serializable ?
    public boolean isImplementationOf(Interface targetInterface, Class cls) {
        Class type = targetInterface.getType();
        return type.isAssignableFrom(cls);
    }

    public boolean isSubclassOf(Class superClass, Class subclass) {
        return superClass.isAssignableFrom(subclass);
    }

    public void checkFieldType(Class expectedType, Object ref, String fieldName) {
        Object value = reflector.getInstanceField(ref, fieldName);
        Class type = value.getClass();
        Assert.assertEquals(expectedType, type);
    }

    public void checkImplementationOfInterfaceAndFinal(Class expectedInterface, Class implClass) {
        String implName = getShortName(implClass);
        checkInterface(expectedInterface, implClass, implName);
        checkFinal(implClass, implName);
    }

    public void checkSubclassOf(Class superClass, Class subClass) {
        String superClassName = getShortName(superClass);
        String subClassName = getShortName(subClass);
        boolean isSubclass = isSubclassOf(superClass, subClass);
        Assert.assertTrue(subClassName + " is not a subclass of " + superClassName, isSubclass);
    }

    public void checkSubclassOf(Class superClass, Object ref) {
        Assert.assertNotNull(ref);
        Class cls = ref.getClass();
        checkSubclassOf(superClass, cls);
    }

    private boolean isInterface(int modifiers) {
        return Modifier.isInterface(modifiers);
    }

    private String getShortName(Class cls) {
        return clsMaster.getShortName(cls);
    }

    private void checkFinal(Class implementationClass, String implName) {
        boolean isFinal = modifiers.isFinal(implementationClass);
        Assert.assertTrue(implName + " must be final", isFinal);
    }

    private void checkInterface(Class expectedInterface, Class implementationClass, String implName) {
        Interface inyerface = new Interface(expectedInterface);
        boolean implementsIt = isImplementationOf(inyerface, implementationClass);
        String targetName = getShortName(expectedInterface);
        Assert.assertTrue(implName + " is not an implementation of " + targetName, implementsIt);
    }
}
