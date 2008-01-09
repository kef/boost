package au.net.netstorm.boost.edge.java.lang.reflect;

import au.net.netstorm.boost.edge.EdgeException;

import java.lang.reflect.Field;

public final class DefaultEdgeField implements EdgeField {
    public Object get(Field field, Object obj) {
        try {
            return field.get(obj);
        } catch (IllegalAccessException e) {
            throw new EdgeException(e);
        }
    }

    public void set(Field field, Object obj, Object value) {
        try {
            field.set(obj, value);
        } catch (IllegalAccessException e) {
            throw new EdgeException(e);
        }
    }
}
