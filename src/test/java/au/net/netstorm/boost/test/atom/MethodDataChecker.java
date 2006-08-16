package au.net.netstorm.boost.test.atom;

import java.lang.reflect.Method;

import au.net.netstorm.boost.util.introspect.FieldSpec;

final class MethodDataChecker implements DataChecker {
    public void checkStructure(Class cls, FieldSpec[] fields) {
        Method[] methods = cls.getDeclaredMethods();
        checkMethodSignatures(cls, fields);
        checkBeanAccessors(cls, fields);
        // FIX SC600 Check each field individually.
        // FIX SC600 BREADCRUMB Ensure the public methods match exactly the field count.
    }

    private void checkMethodSignatures(Class cls, FieldSpec[] fields) {
        // FIX SC600 BREADCRUMB Ensure no protected/package private methods.
    }

    private void checkBeanAccessors(Class cls, FieldSpec[] fields) {
        for (int i = 0; i < fields.length; i++) {
            checkBeanAccessor(cls, fields[i]);

        }
    }

    private void checkBeanAccessor(Class cls, FieldSpec field) {
        // FIX SC600 Check name.
        // FIX SC600 Check type.
        // FIX SC600 Ensure method is public, instance method.
    }
}
