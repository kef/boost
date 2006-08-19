package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.test.reflect.util.DefaultModifierTestUtil;
import au.net.netstorm.boost.test.reflect.util.ModifierTestUtil;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import junit.framework.Assert;

import java.lang.reflect.Method;

final class ClassMethodStructureDataChecker implements DataChecker {
    private ModifierTestUtil modifierUtil = new DefaultModifierTestUtil();
    private ClassMethodUtil classMethodUtil = new DefaultClassMethodUtil();

    public void check(Class cls, FieldSpec[] fields) {
        checkMethodSignatures(cls);
        // FIX SC600 Check each field individually.
        // FIX SC600 Check return type.
        // FIX SC600 BREADCRUMB Ensure the public methods match exactly the field count.
        checkClassInterface(cls, fields);
    }

    private void checkMethodSignatures(Class cls) {
        Method[] methods = classMethodUtil.getAll(cls);
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

    private void checkClassInterface(Class cls, FieldSpec[] fields) {
        Method[] methods = classMethodUtil.getAllNotInheritedPublicInstance(cls);
        if (methods.length <= fields.length) return;
        fail("Too many public methods.  Only getters for the specified properties are allowed.");
    }

    private void checkMethodHasNoArguments(Method method) {
        Class[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length == 0) return;
        String name = toString(method);
        fail(name + " has arguments.  All property accessor methods must have no arguments");
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
