package au.net.netstorm.boost.edge.java.lang.reflect;

import java.lang.reflect.Field;

import au.net.netstorm.boost.edge.EdgeException;

public final class DefaultEdgeField implements EdgeField {
    // FIX SC600 Rename to match.
    public Object getFieldValue(Field field, Object obj) {
        try {
            return field.get(obj);
        } catch (IllegalAccessException e) {
            throw new EdgeException(e);
        }
    }

    // FIX SC600 Rename to match.
    public void setFieldValue(Field field, Object obj, Object value) {
        try {
            field.set(obj, value);
        } catch (IllegalAccessException e) {
            throw new EdgeException(e);
        }
    }
}
