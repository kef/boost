package au.net.netstorm.boost.sledge.java.lang.reflect;

import java.lang.reflect.Field;
import au.net.netstorm.boost.sledge.support.EdgeException;

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
