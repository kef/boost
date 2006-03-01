package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Field;

public class DefaultFieldTestUtil implements FieldTestUtil {
    private static final Object MARKER_STATIC_FIELD = null;
    private ReflectEdge reflectEdge = ReflectEdge.INSTANCE;

    public Object getStaticField(Class cls, String fieldName) {
        return getFieldValue(cls, MARKER_STATIC_FIELD, fieldName);
    }

    // FIXME: SC042 Return a FieldValue might be a goodie.  Could even use it on the way in for the set.
    public Object getInstanceField(Object ref, String fieldName) {
        Class cls = ref.getClass();
        return getFieldValue(cls, ref, fieldName);
    }

    // FIXME: SC042 Use edger.
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
}
