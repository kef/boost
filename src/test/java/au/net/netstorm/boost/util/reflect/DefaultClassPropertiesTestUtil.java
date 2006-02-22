package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import au.net.netstorm.boost.util.type.Interface;
import junit.framework.Assert;

// FIXME: SC042 Interface.
// FIXME: SC042 BREADCRUMB Instance rather than static.
// FIXME: SC042 No train wrecks.
public class DefaultClassPropertiesTestUtil implements ClassPropertiesTestUtil {
    private final DefaultReflectTestUtil reflector = new DefaultReflectTestUtil();
    private final ClassMaster clsMaster = new DefaultClassMaster();

    public boolean isPublicInstance(Method method) {
        int modifiers = method.getModifiers();
        if (!isPublic(modifiers)) return false;
        return !isStatic(modifiers);
    }

    // FIXME: SC042 Rename to isAbstract.  Same for below.
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

    // FIXME: SC506 Reformat all code (especially wrap train wrecks).
    // FIXME: SC506 This did not appear to work for targetInterface == java.io.Serializable ?
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

    // FIXME: SC042 - Complete tidy up of ReflectTestUtil.  Look for all new ReflectTestUtil instances.
    public void checkFieldType(Class expectedClass, Object ref, String fieldName) {
        try {
            Field field = reflector.getDeclaredField(ref.getClass(), fieldName);
            field.setAccessible(true);
            Assert.assertEquals(expectedClass, field.get(ref).getClass());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void checkImplementationOfInterfaceAndFinal(Class targetInterface, Class implementationClass) {
        Interface inyerface = new Interface(targetInterface);
        String implName = getShortName(implementationClass);
        String targetName = getShortName(targetInterface);
        boolean implementsIt = isImplementationOf(inyerface, implementationClass);
        Assert.assertTrue(implName + " is not an implementation of " + targetName, implementsIt);
        Assert.assertTrue(implName + " must be final", isFinal(implementationClass));
    }

    private String getShortName(Class cls) {
        return clsMaster.getShortName(cls);
    }

    public void checkSubclassOf(Class superClass, Class subClass) {
        Assert.assertTrue(getShortName(subClass) + " is not a subclass of " + getShortName(superClass), isSubclassOf(superClass, subClass));
    }

    public void checkClassFinal(Class cls) {
        Assert.assertTrue(isFinal(cls));
    }

    public void checkClassPublic(Class cls) {
        Assert.assertTrue(isPublic(cls));
    }

    public void checkInstance(Class expectedImpl, Object ref) {
        Assert.assertNotNull(ref);
        Assert.assertTrue(isSubclassOf(expectedImpl, ref.getClass()));
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
}
