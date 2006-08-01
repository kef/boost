package au.net.netstorm.boost.test.reflect;

import java.lang.reflect.Field;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeField;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeField;
import au.net.netstorm.boost.util.introspect.FieldValueSpec;

public class DefaultFieldTestUtil implements FieldTestUtil {
    private static final Object MARKER_STATIC_FIELD = null;
    private final EdgeField edgeField = new DefaultEdgeField();
    private final EdgeClass edgeClass = new DefaultEdgeClass();

    public Field getDeclared(Class cls, String fieldName) {
        return edgeClass.getDeclaredField(cls, fieldName);
    }

    public Object getStatic(Class cls, String fieldName) {
        return getFieldValue(cls, MARKER_STATIC_FIELD, fieldName);
    }

    public Object getInstance(Object ref, Field field) {
        return value(ref, field);
    }

    public Object getInstance(Object ref, String fieldName) {
        Class cls = ref.getClass();
        return getFieldValue(cls, ref, fieldName);
    }

    public void setInstance(Object ref, String fieldName, Object fieldValue) {
        Class cls = ref.getClass();
        setField(cls, ref, fieldName, fieldValue);
    }

    public void setInstance(Object ref, FieldValueSpec fieldValue) {
        String name = fieldValue.getName();
        Object value = fieldValue.getValue();
        setInstance(ref, name, value);
    }

    public void setStatic(Class cls, String fieldName, Object fieldValue) {
        Object ref = MARKER_STATIC_FIELD;
        setField(cls, ref, fieldName, fieldValue);
    }

    public void setStatic(Class cls, FieldValueSpec fieldValue) {
        String name = fieldValue.getName();
        Object value = fieldValue.getValue();
        setStatic(cls, name, value);
    }

    private void setField(Class cls, Object f, String fieldName, Object fieldValue) {
        Field field = getDeclared(cls, fieldName);
        setField(f, field, fieldValue);
    }

    private void setField(Object ref, Field field, Object value) {
        field.setAccessible(true);
        edgeField.setFieldValue(field, ref, value);
    }

    private Object getFieldValue(Class cls, Object ref, String fieldName) {
        Field field = getDeclared(cls, fieldName);
        return value(ref, field);
    }

    private Object value(Object ref, Field field) {
        field.setAccessible(true);
        return edgeField.getFieldValue(field, ref);
    }
}
// SUGGEST: Imagine if all these utilities took Edge*
