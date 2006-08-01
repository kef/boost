package au.net.netstorm.boost.edge.java.lang.reflect;

import java.lang.reflect.Field;

public interface EdgeField {
    Object getFieldValue(Field field, Object ref);

    void setFieldValue(Field field, Object ref, Object value);
}
