package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Field;

// FIXME: SC042 Change field names for all references to this. (DO SAME FOR METHOD, CLASS ...)
// FIXME: SC042 Include methods which take FieldValue.

public interface FieldTestUtil {
    Field getDeclared(Class cls, String fieldName);

    Object getStatic(Class cls, String fieldName);

    Object getInstance(Object ref, String fieldName);

    void setInstance(Object ref, String fieldName, Object value);

    void setStatic(Class cls, String fieldName, Object value);
}
