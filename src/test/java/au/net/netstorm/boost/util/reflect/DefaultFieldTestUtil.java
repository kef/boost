package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Field;

import au.net.netstorm.boost.util.introspect.FieldValueSpec;

public class DefaultFieldTestUtil implements FieldTestUtil {
    private static final Object MARKER_STATIC_FIELD = null;
    private final ReflectEdge reflectEdge = ReflectEdge.INSTANCE;

    // FIXME: SC042 Use edger.
    public Field getDeclared(Class cls, String fieldName) {
        try {
            return cls.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(cls + " does not contain field " + fieldName, e);
        }
    }

    public Object getStatic(Class cls, String fieldName) {
        return getFieldValue(cls, MARKER_STATIC_FIELD, fieldName);
    }

    public Object getInstance(Object ref, String fieldName) {
        Class cls = ref.getClass();
        return getFieldValue(cls, ref, fieldName);
    }

    public void setInstance(Object ref, String fieldName, Object fieldValue) {
        Class cls = ref.getClass();
        setField(cls, ref, fieldName, fieldValue);
    }

    public void setInstance(Object ref, FieldValueSpec fieldValueSpec) {
        String name = fieldValueSpec.getName();
        Object value = fieldValueSpec.getValue();
        setInstance(ref, name, value);
    }

    public void setStatic(Class cls, String fieldName, Object fieldValue) {
        Object ref = MARKER_STATIC_FIELD;
        setField(cls, ref, fieldName, fieldValue);
    }

    public void setStatic(Class cls, FieldValueSpec fieldValueSpec) {
        String name = fieldValueSpec.getName();
        Object value = fieldValueSpec.getValue();
        setStatic(cls, name, value);
    }

    private void setField(Class cls, Object f, String fieldName, Object fieldValue) {
        Field field = getDeclared(cls, fieldName);
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
        Field field = getDeclared(cls, fieldName);
        return value(ref, field);
    }

    private Object value(Object ref, Field field) {
        field.setAccessible(true);
        return reflectEdge.get(field, ref);
    }
}
