package au.net.netstorm.boost.test.reflect.checker;

public interface FieldTestChecker {
    void checkPrivateFinalInstanceField(Class type, String fieldName);

    void checkInstanceType(Class expectedClass, Object ref, String fieldName);
}
