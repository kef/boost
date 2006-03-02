package au.net.netstorm.boost.util.reflect;

public interface FieldTestChecker {
    void checkPrivateFinalInstanceField(Class type, String fieldName);

    void checkType(Class expectedClass, Object ref, String fieldName);
}
