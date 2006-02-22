package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import au.net.netstorm.boost.util.type.Interface;
import junit.framework.Assert;

// FIXME: SC042 Remove train wrecks.
// FIXME: SC042 Use edge below for exception.
public class DefaultClassPropertiesTestUtil implements ClassPropertiesTestUtil {
    private final ReflectTestUtil reflector = new DefaultReflectTestUtil();
    private final ClassMaster clsMaster = new DefaultClassMaster();

    public boolean isPublicInstance(Method method) {
        int modifiers = method.getModifiers();
        if (!isPublic(modifiers)) return false;
        return !isStatic(modifiers);
    }

    public boolean isAbstract(Class cls) {
        int modifiers = cls.getModifiers();
        return isAbstract(modifiers);
    }

    public boolean isFinal(Class cls) {
        int modifiers = cls.getModifiers();
        return isFinal(modifiers);
    }

    public boolean isPublic(Class cls) {
        int modifiers = cls.getModifiers();
        return isPublic(modifiers);
    }

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

    public boolean isFinal(Method method) {
        int modifiers = method.getModifiers();
        return isFinal(modifiers);
    }

    public void checkFieldType(Class expectedType, Object ref, String fieldName) {
        try {
            Object fieldValue = getFieldValue(ref, fieldName);
            Class type = fieldValue.getClass();
            Assert.assertEquals(expectedType, type);

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void checkImplementationOfInterfaceAndFinal(Class expectedInterface, Class implClass) {
        String implName = getShortName(implClass);
        String targetName = getShortName(expectedInterface);
        checkInterface(implClass, implName, expectedInterface, targetName);
        checkFinal(implClass, implName);
    }

    public void checkSubclassOf(Class superClass, Class subClass) {
        String subClassName = getShortName(subClass);
        String superClassName = getShortName(superClass);
        boolean isSubclass = isSubclassOf(superClass, subClass);
        Assert.assertTrue(subClassName + " is not a subclass of " + superClassName, isSubclass);
    }

    public void checkClassFinal(Class cls) {
        Assert.assertTrue(isFinal(cls));
    }

    public void checkClassPublic(Class cls) {
        Assert.assertTrue(isPublic(cls));
    }

    public void checkInstance(Class expectedImpl, Object ref) {
        Assert.assertNotNull(ref);
        Class cls = ref.getClass();
        Assert.assertTrue(isSubclassOf(expectedImpl, cls));
    }

    private boolean isAbstract(int modifiers) {
        return Modifier.isAbstract(modifiers);
    }

    private boolean isInterface(int modifiers) {
        return Modifier.isInterface(modifiers);
    }

    private boolean isPublic(int modifiers) {
        return Modifier.isPublic(modifiers);
    }

    private boolean isFinal(int modifiers) {
        return Modifier.isFinal(modifiers);
    }

    private boolean isStatic(int modifiers) {
        return Modifier.isStatic(modifiers);
    }

    private String getShortName(Class cls) {
        return clsMaster.getShortName(cls);
    }

    private void checkFinal(Class implementationClass, String implName) {
        boolean isFinal = isFinal(implementationClass);
        Assert.assertTrue(implName + " must be final", isFinal);
    }

    private void checkInterface(Class implementationClass, String implName, Class targetInterface, String targetName) {
        Interface inyerface = new Interface(targetInterface);
        boolean implementsIt = isImplementationOf(inyerface, implementationClass);
        Assert.assertTrue(implName + " is not an implementation of " + targetName, implementsIt);
    }

    private Object getFieldValue(Object ref, String fieldName) throws IllegalAccessException {
        Class cls = ref.getClass();
        Field field = reflector.getDeclaredField(cls, fieldName);
        field.setAccessible(true);
        return field.get(ref);
    }
}
