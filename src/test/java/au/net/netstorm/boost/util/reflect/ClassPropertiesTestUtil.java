package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import au.net.netstorm.boost.util.type.Interface;
import junit.framework.Assert;

// FIXME: SC506 Instance rather than static.

public class ClassPropertiesTestUtil extends Assert {
    public static boolean isPublicInstance(Method method) {
        int modifiers = method.getModifiers();
        if (!Modifier.isPublic(modifiers)) return false;
        return !Modifier.isStatic(modifiers);
    }

    public static boolean isClassAbstract(Class cls) {
        return Modifier.isAbstract(cls.getModifiers());
    }

    public static boolean isClassFinal(Class cls) {
        return Modifier.isFinal(cls.getModifiers());
    }

    public static boolean isClassPublic(Class cls) {
        return Modifier.isPublic(cls.getModifiers());
    }

    public static boolean isClassAnInterface(Class cls) {
        return Modifier.isInterface(cls.getModifiers());
    }

    // FIXME: SC506 Reformat all code (especially wrap train wrecks).
// FIXME: SC506 This did not appear to work for targetInterface == java.io.Serializable ?

    public static boolean isImplementationOf(Interface targetInterface, Class cls) {
        Class type = targetInterface.getType();
        return type.isAssignableFrom(cls);
    }

    public static boolean isSubclassOf(Class superClass, Class subclass) {
        return superClass.isAssignableFrom(subclass);
    }

    public static boolean isMethodFinal(Method method) {
        return Modifier.isFinal(method.getModifiers());
    }

    // FIXME: SC042 - Complete tidy up of ReflectTestUtil.  Look for all new ReflectTestUtil instances.
    public static void checkFieldType(Object ref, String fieldName, Class expectedClass) {
        try {
            Field field = new DefaultReflectTestUtil().getDeclaredField(ref.getClass(), fieldName);
            field.setAccessible(true);
            assertEquals(expectedClass, field.get(ref).getClass());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void checkImplementationOfInterfaceAndFinal(Class targetInterface, Class implementationClass) {
        Interface inyerface = new Interface(targetInterface);
        assertTrue(getName(implementationClass) + " is not an implementation of " + getName(targetInterface), isImplementationOf(inyerface, implementationClass));
        assertTrue(getName(implementationClass) + " must be final", isClassFinal(implementationClass));
    }

    private static String getName(Class implementationClass) {
        return new DefaultClassMaster().getShortName(implementationClass);
    }

    public static void checkSubclassOf(Class superClass, Class subClass) {
        Assert.assertTrue(getName(subClass) + " is not a subclass of " + getName(superClass), isSubclassOf(superClass, subClass));
    }

    public static void checkClassFinal(Class cls) {
        Assert.assertTrue(isClassFinal(cls));
    }

    public static void checkClassPublic(Class cls) {
        Assert.assertTrue(isClassPublic(cls));
    }

    public static void checkInstance(Class expectedImpl, Object ref) {
        Assert.assertNotNull(ref);
        Assert.assertTrue(isSubclassOf(expectedImpl, ref.getClass()));
    }
}
