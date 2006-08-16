package au.net.netstorm.boost.test.atom;

import java.lang.reflect.Method;

import au.net.netstorm.boost.test.reflect.util.DefaultModifierTestUtil;
import au.net.netstorm.boost.test.reflect.util.ModifierTestUtil;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import junit.framework.Assert;

final class MethodDataChecker implements DataChecker {
    private ModifierTestUtil modifierUtil = new DefaultModifierTestUtil();

    public void checkStructure(Class cls, FieldSpec[] fields) {
        checkMethodSignatures(cls);
        checkBeanAccessors(cls, fields);
        // FIX SC600 Check each field individually.
        // FIX SC600 BREADCRUMB Ensure the public methods match exactly the field count.
    }

    private void checkMethodSignatures(Class cls) {
        Method[] methods = getAllMethods(cls);
        for (int i = 0; i < methods.length; i++) {
            checkMethodScope(methods[i]);
            // FIX SC600 Must be no-arg method.
        }
    }

    private void checkMethodScope(Method method) {
        String methodName = method.getName();
        if (modifierUtil.isPublicInstance(method)) return;
        if (modifierUtil.isPrivate(method)) return;
        fail("All methods must be public non-static or private.  Method " + methodName + "() violates this constraint.");
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

    private Method[] getAllMethods(Class cls) {
        return cls.getDeclaredMethods();
    }

    private void fail(String msg) {
        Assert.fail(msg);
    }
}
