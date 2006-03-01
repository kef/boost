package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Field;

// FIXME: SC042 Change field names for all references to this. (DO SAME FOR METHOD, CLASS ...)
// FIXME: SC042 Include methods which take FieldValue.
// FIXME: SC042 Make sure ordering in implementation matches.

public interface FieldTestUtil {
    // FIXME: SC042 Remove field from all methods names.
    Object getStatic(Class cls, String fieldName);

    Object getInstance(Object ref, String fieldName);

    Field getDeclared(Class cls, String fieldName);

    void setInstance(Object ref, String fieldName, Object value);

    void setStatic(Class cls, String fieldName, Object value);
}
