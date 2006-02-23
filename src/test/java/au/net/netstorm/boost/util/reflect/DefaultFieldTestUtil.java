package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import junit.framework.Assert;

// FIXME: SC509 Merge with reflection test util.
// FIXME: SC506 Extend Assert to get Assert.fails out the way.

public class DefaultFieldTestUtil implements FieldTestUtil {
    private static final Object MARKER_STATIC_FIELD = null;
    private ReflectEdge reflectEdge = ReflectEdge.INSTANCE;

    public Class getExceptionType(Method method) {
        Class[] exceptions = method.getExceptionTypes();
        String name = method.getName();
        Assert.assertTrue(name + "() must throw a single exception.", exceptions.length == 1);
        return exceptions[0];
    }

    public Object getStaticField(Class cls, String fieldName) {
        return getFieldValue(cls, MARKER_STATIC_FIELD, fieldName);
    }

    // FIXME: SC042 Return a FieldValue might be a goodie.  Could even use it on the way in for the set.
    public Object getInstanceField(Object ref, String fieldName) {
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

    public void setInstanceField(Object ref, String fieldName, Object fieldValue) {
        Class cls = ref.getClass();
        setField(cls, ref, fieldName, fieldValue);
    }

    public void setStaticField(Class cls, String fieldName, Object fieldValue) {
        Object ref = MARKER_STATIC_FIELD;
        setField(cls, ref, fieldName, fieldValue);
    }

    public void checkPrivateFinalField(Class type, String fieldName) {
        Field field = getDeclaredField(type, fieldName);
        int modifiers = field.getModifiers();
        if (!Modifier.isFinal(modifiers)) Assert.fail("Field '" + fieldName + "' should be declared final.");
        if (Modifier.isPublic(modifiers)) Assert.fail("Field '" + fieldName + "' should be declared private.");
        if (Modifier.isStatic(modifiers)) Assert.fail("Field '" + fieldName + "' cannot be static.");
    }

    public boolean isPublic(Method method) {
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
            // FIXME: SC042 No exception catching if we move into reflect edge.
            throw new RuntimeException(e);
        }
    }

    private Object getFieldValue(Class cls, Object ref, String fieldName) {
        Field field = getDeclaredField(cls, fieldName);
        return value(ref, field);
    }

    private Object value(Object ref, Field field) {
        field.setAccessible(true);
        return reflectEdge.get(field, ref);
    }

    public Class getRealExceptionClass(RuntimeException e) {
        // FIXME: SC050 This certainly does not really work.  Sort this out!!!
        Throwable realException = e;
        if (realException.getClass() == RuntimeException.class) realException = (Throwable) realException.getCause();
        if (realException.getClass() == InvocationTargetException.class)
            realException = (Throwable) realException.getCause();
        return realException.getClass();
    }
}
