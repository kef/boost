package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.test.reflect.util.DefaultModifierTestUtil;
import au.net.netstorm.boost.test.reflect.util.ModifierTestUtil;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import junit.framework.Assert;

import java.lang.reflect.Method;

final class MethodDataChecker implements DataChecker {
    private static final Class[] NO_PARAMETERS = {};
    private ModifierTestUtil modifierUtil = new DefaultModifierTestUtil();
    private EdgeClass edgeClass = new DefaultEdgeClass();
    private PropertyNameProvider nameProvider = new DefaultPropertyNameProvider();

    public void checkStructure(Class cls, FieldSpec[] fields) {
        checkMethodSignatures(cls);
        checkPropertyMethods(cls, fields);
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
        String name = toString(method);
        fail("All methods must be public non-static or private.  " + name + " violates this constraint.");
    }

    private void checkMethodHasNoArguments(Method method) {
        Class[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length == 0) return;
        String name = toString(method);
        fail(name + " has arguments.  All property accessor methods must have no arguments");
    }

    private void checkPropertyMethods(Class cls, FieldSpec[] fields) {
        for (int i = 0; i < fields.length; i++) {
            checkPropertyAccessor(cls, fields[i]);
        }
    }

    private void checkPropertyAccessor(Class cls, FieldSpec field) {
        String propertyName = nameProvider.getPropertyMethodName(field);
        checkMethodExists(cls, propertyName);
        chechMethodSignature(cls, propertyName);
    }

    private void checkMethodExists(Class cls, String methodName) {
        try {
            cls.getDeclaredMethod(methodName, NO_PARAMETERS);
        } catch (NoSuchMethodException e) {
            // FIXME: SC600 BREADCRUMB.
            // FIXME: SC600 Remove dupe here
            fail(toString(methodName) + " expected but not found.");
        }
    }

    private void chechMethodSignature(Class cls, String methodName) {
        Method method = edgeClass.getDeclaredMethod(cls, methodName, NO_PARAMETERS);
        // FIX SC600 BREADCRUMB Sort out line wrap issue.
        if (!modifierUtil.isPublicInstance(method)) fail(toString(methodName) + " must be a public instance method.");
        // FIXME: SC600 check return type.
    }

    private Method[] getAllMethods(Class cls) {
        return cls.getDeclaredMethods();
    }

    private String toString(Method method) {
        String methodName = method.getName();
        return toString(methodName);
    }

    private String toString(String methodName) {
        return "Method " + methodName + "()";
    }

    private void fail(String msg) {
        Assert.fail(msg);
    }
}
