package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Field;

import au.net.netstorm.boost.util.introspect.FieldValueSpec;

public interface FieldTestUtil {
    Field getDeclared(Class cls, String fieldName);

    Object getStatic(Class cls, String fieldName);

    Object getInstance(Object ref, String fieldName);

    void setInstance(Object ref, String fieldName, Object value);

    void setInstance(Object ref, FieldValueSpec fieldValueSpec);

    void setStatic(Class cls, String fieldName, Object value);

    void setStatic(Class cls, FieldValueSpec fieldValueSpec);
}
