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
    private static DefaultReflectTestUtil reflector = new DefaultReflectTestUtil();

    public boolean isPublicInstance(Method method) {
        int modifiers = method.getModifiers();
        if (!Modifier.isPublic(modifiers)) return false;
        return !Modifier.isStatic(modifiers);
    }

    // FIXME: SC042 Rename to isAbstract.  Same for below.
    public boolean isClassAbstract(Class cls) {
        return Modifier.isAbstract(cls.getModifiers());
    }

    public boolean isClassFinal(Class cls) {
        return Modifier.isFinal(cls.getModifiers());
    }

    public boolean isClassPublic(Class cls) {
        return Modifier.isPublic(cls.getModifiers());
    }

    public boolean isClassAnInterface(Class cls) {
        return Modifier.isInterface(cls.getModifiers());
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

    public boolean isMethodFinal(Method method) {
        return Modifier.isFinal(method.getModifiers());
    }

    // FIXME: SC042 - Complete tidy up of ReflectTestUtil.  Look for all new ReflectTestUtil instances.
    public void checkFieldType(Object ref, String fieldName, Class expectedClass) {
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
        Assert.assertTrue(getName(implementationClass) + " is not an implementation of " + getName(targetInterface), isImplementationOf(inyerface, implementationClass));
        Assert.assertTrue(getName(implementationClass) + " must be final", isClassFinal(implementationClass));
    }

    private String getName(Class implementationClass) {
        return new DefaultClassMaster().getShortName(implementationClass);
    }

    public void checkSubclassOf(Class superClass, Class subClass) {
        Assert.assertTrue(getName(subClass) + " is not a subclass of " + getName(superClass), isSubclassOf(superClass, subClass));
    }

    public void checkClassFinal(Class cls) {
        Assert.assertTrue(isClassFinal(cls));
    }

    public void checkClassPublic(Class cls) {
        Assert.assertTrue(isClassPublic(cls));
    }

    public void checkInstance(Class expectedImpl, Object ref) {
        Assert.assertNotNull(ref);
        Assert.assertTrue(isSubclassOf(expectedImpl, ref.getClass()));
    }
}
