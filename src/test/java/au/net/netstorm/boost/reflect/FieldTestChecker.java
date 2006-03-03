package au.net.netstorm.boost.reflect;

public interface FieldTestChecker {
    void checkPrivateFinalInstanceField(Class type, String fieldName);

    void checkInstanceType(Class expectedClass, Object ref, String fieldName);
}
