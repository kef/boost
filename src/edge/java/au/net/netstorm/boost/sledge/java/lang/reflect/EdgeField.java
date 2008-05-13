package au.net.netstorm.boost.sledge.java.lang.reflect;

import java.lang.reflect.Field;

public interface EdgeField {
    Object get(Field field, Object ref);

    void set(Field field, Object ref, Object value);
}
