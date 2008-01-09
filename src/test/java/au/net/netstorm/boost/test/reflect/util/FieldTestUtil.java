package au.net.netstorm.boost.test.reflect.util;

import au.net.netstorm.boost.util.introspect.FieldValueSpec;

import java.lang.reflect.Field;

public interface FieldTestUtil {
    Field get(Class cls, String fieldName);

    Field getPublic(Class cls, String fieldName);

    Object getStatic(Class cls, String fieldName);

    Object getPublicStatic(Class cls, String fieldName);

    Object getInstance(Object ref, Field field);

    Object getInstance(Object ref, String fieldName);

    Object getPublicInstance(Object ref, String fieldName);

    void setInstance(Object ref, String fieldName, Object value);

    void setInstance(Object ref, FieldValueSpec fieldValue);

    void setPublicInstance(Object ref, String fieldName, Object value);

    void setPublicInstance(Object ref, FieldValueSpec fieldValue);

    void setStatic(Class cls, String fieldName, Object value);

    void setStatic(Class cls, FieldValueSpec fieldValue);
}
