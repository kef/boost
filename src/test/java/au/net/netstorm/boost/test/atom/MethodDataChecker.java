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
        // FIX SC600 Check return type.
        // FIX SC600 BREADCRUMB Ensure the public methods match exactly the field count.
    }

    private void checkMethodSignatures(Class cls) {
        Method[] methods = getAllMethods(cls);
        for (int i = 0; i < methods.length; i++) {
            checkMethodScope(methods[i]);
            checkMethodHasNoArguments(methods[i]);
        }
    }

    private void checkMethodScope(Method method) {
        if (modifierUtil.isPublicInstance(method)) return;
        if (modifierUtil.isPrivate(method)) return;
        String name = getName(method);
        fail("All methods must be public non-static or private.  " + name + " violates this constraint.");
    }

    private void checkMethodHasNoArguments(Method method) {
        Class[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length == 0) return;
        String name = getName(method);
        fail(name + " has arguments.  All property accessor methods must have no arguments");
    }

    private void checkBeanAccessors(Class cls, FieldSpec[] fields) {
        for (int i = 0; i < fields.length; i++) {
            checkBeanAccessor(cls, fields[i]);
        }
    }

    private void checkBeanAccessor(Class cls, FieldSpec field) {
        getBeanName(field);
        // FIX SC600 Check name.
        // FIX SC600 Check type.
        // FIX SC600 Ensure method is public, instance method.
    }

    private void getBeanName(FieldSpec field) {
        String beanName = field.getName();
        // FIX SC600 BREADCRUMB.
    }

    private Method[] getAllMethods(Class cls) {
        return cls.getDeclaredMethods();
    }

    private String getName(Method method) {
        String name = method.getName();
        return "Method " + name + "()";
    }

    private void fail(String msg) {
        Assert.fail(msg);
    }
}
