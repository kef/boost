package au.net.netstorm.boost.util.reflect;

import java.lang.reflect.Field;

// FIXME: SC042 In fact this mostly smells like a FieldTestUtil.

// FIXME: SC042 Change field names for all references to this. (DO SAME FOR METHOD, CLASS ...)

public interface FieldTestUtil {
    // FIXME: SC042 Remove field from all methods names.
    Object getStaticField(Class cls, String fieldName);

    Object getInstanceField(Object ref, String fieldName);

    Field getDeclaredField(Class cls, String fieldName);

    void setInstanceField(Object ref, String fieldName, Object fieldValue);

    void setStaticField(Class cls, String fieldName, Object fieldValue);

    void checkPrivateFinalField(Class type, String fieldName); // FIXME: SC042 This "check*" does not seem to fit here.
}
