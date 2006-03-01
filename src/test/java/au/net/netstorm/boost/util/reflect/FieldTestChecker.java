package au.net.netstorm.boost.util.reflect;

public interface FieldTestChecker {
    void checkPrivateFinalField(Class type, String fieldName);

    void checkFieldType(Class expectedClass, Object ref, String fieldName);
}
