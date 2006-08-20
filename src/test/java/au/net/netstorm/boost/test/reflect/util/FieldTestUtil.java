package au.net.netstorm.boost.test.reflect.util;

import au.net.netstorm.boost.util.introspect.FieldValueSpec;

import java.lang.reflect.Field;

public interface FieldTestUtil {
    Field getDeclared(Class cls, String fieldName);

    Object getStatic(Class cls, String fieldName);

    Object getInstance(Object ref, Field field);

    Object getInstance(Object ref, String fieldName);

    void setInstance(Object ref, String fieldName, Object value);

    void setInstance(Object ref, FieldValueSpec fieldValue);

    void setStatic(Class cls, String fieldName, Object value);

    void setStatic(Class cls, FieldValueSpec fieldValue);
}
