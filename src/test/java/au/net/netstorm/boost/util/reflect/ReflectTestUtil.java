package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import junit.framework.Assert;

// FIXME: SC509 Merge with reflection test util.
// FIXME: SC506 Make instance.  Surely most of this is implemented in production code.
// FIXME: SC506 Extend Assert to get Assert.fails out the way.
public class ReflectTestUtil {
    public static Class getException(Method method) {
        Class[] exceptions = method.getExceptionTypes();
        Assert.assertTrue(method.getName() + "() must throw a single exception.", exceptions.length == 1);
        return exceptions[0];
    }

    public static Object getStaticFieldValue(Class cls, String fieldName) {
        return getFieldValue(cls, null, fieldName);
    }

    public static Object getInstanceFieldValue(Object ref, String fieldName) {
        return getFieldValue(ref.getClass(), ref, fieldName);
    }

    public static Field getDeclaredField(Class cls, String fieldName) {
        try {
            return cls.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(cls + " does not contain field " + fieldName, e);
        }
    }

    public static void setInstanceFieldValue(Object ref, String fieldName, Object fieldValue) {
        setField(ref, getDeclaredField(ref.getClass(), fieldName), fieldValue);
    }

    public static void setStaticFieldValue(Class cls, String fieldName, Object fieldValue) {
        setField(null, getDeclaredField(cls, fieldName), fieldValue);
    }

    public static void checkPrivateFinalField(Class type, String fieldName) {
        Field field = getDeclaredField(type, fieldName);
        int modifiers = field.getModifiers();
        if (!Modifier.isFinal(modifiers)) Assert.fail("Field '" + fieldName + "' should be declared final.");
        if (Modifier.isPublic(modifiers)) Assert.fail("Field '" + fieldName + "' should be declared private.");
        if (Modifier.isStatic(modifiers)) Assert.fail("Field '" + fieldName + "' cannot be static.");
    }

    public static boolean methodIsPublic(Method method) {
        return Modifier.isPublic(method.getModifiers());
    }

    private static void setField(Object ref, Field field, Object fieldValue) {
        try {
            field.setAccessible(true);
            field.set(ref, fieldValue);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static Object getFieldValue(Class cls, Object ref, String fieldName) {
        Field field = getDeclaredField(cls, fieldName);
        return value(ref, field);
    }

    private static Object value(Object ref, Field field) {
        field.setAccessible(true);
        return ReflectEdge.INSTANCE.get(field, ref);
    }

    public static Class getRealExceptionClass(RuntimeException e) {
        Throwable realException = e;
        if (realException.getClass() == RuntimeException.class) realException = (Throwable) realException.getCause();
        if (realException.getClass() == InvocationTargetException.class) realException = (Throwable) realException.getCause();
        return realException.getClass();
    }
}
