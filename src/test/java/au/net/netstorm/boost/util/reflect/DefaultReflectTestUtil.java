package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import junit.framework.Assert;

// FIXME: SC042 Should be using edge classes.
// FIXME: SC509 Merge with reflection test util.
// FIXME: SC042 Make instance.  Surely most of this is implemented in production code.
// FIXME: SC506 Extend Assert to get Assert.fails out the way.
public class DefaultReflectTestUtil implements ReflectTestUtil {
    private static final Object STATIC_FIELD = null;

    public Class getException(Method method) {
        Class[] exceptions = method.getExceptionTypes();
        String name = method.getName();
        Assert.assertTrue(name + "() must throw a single exception.", exceptions.length == 1);
        return exceptions[0];
    }

    public Object getStaticFieldValue(Class cls, String fieldName) {
        return getFieldValue(cls, STATIC_FIELD, fieldName);
    }

    public Object getInstanceFieldValue(Object ref, String fieldName) {
        Class cls = ref.getClass();
        return getFieldValue(cls, ref, fieldName);
    }

    public Field getDeclaredField(Class cls, String fieldName) {
        try {
            return cls.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(cls + " does not contain field " + fieldName, e);
        }
    }

    public void setInstanceFieldValue(Object ref, String fieldName, Object fieldValue) {
        Class cls = ref.getClass();
        setField(cls, ref, fieldName, fieldValue);
    }

    public void setStaticFieldValue(Class cls, String fieldName, Object fieldValue) {
        Object ref = STATIC_FIELD;
        setField(cls, ref, fieldName, fieldValue);
    }

    public void checkPrivateFinalField(Class type, String fieldName) {
        Field field = getDeclaredField(type, fieldName);
        int modifiers = field.getModifiers();
        if (!Modifier.isFinal(modifiers)) Assert.fail("Field '" + fieldName + "' should be declared final.");
        if (Modifier.isPublic(modifiers)) Assert.fail("Field '" + fieldName + "' should be declared private.");
        if (Modifier.isStatic(modifiers)) Assert.fail("Field '" + fieldName + "' cannot be static.");
    }

    public boolean methodIsPublic(Method method) {
        int modifiers = method.getModifiers();
        return Modifier.isPublic(modifiers);
    }

    private void setField(Class cls, Object f, String fieldName, Object fieldValue) {
        Field field = getDeclaredField(cls, fieldName);
        setField(f, field, fieldValue);
    }

    private void setField(Object ref, Field field, Object value) {
        try {
            field.setAccessible(true);
            field.set(ref, value);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private Object getFieldValue(Class cls, Object ref, String fieldName) {
        Field field = getDeclaredField(cls, fieldName);
        return value(ref, field);
    }

    private Object value(Object ref, Field field) {
        field.setAccessible(true);
        return ReflectEdge.INSTANCE.get(field, ref);
    }

    public Class getRealExceptionClass(RuntimeException e) {
        // FIXME: SC050 This certainly does not really work.  Sort this out!!!
        Throwable realException = e;
        if (realException.getClass() == RuntimeException.class) realException = (Throwable) realException.getCause();
        if (realException.getClass() == InvocationTargetException.class) realException = (Throwable) realException.getCause();
        return realException.getClass();
    }
}
