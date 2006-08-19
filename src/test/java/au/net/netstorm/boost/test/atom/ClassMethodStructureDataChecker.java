package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.test.reflect.util.DefaultModifierTestUtil;
import au.net.netstorm.boost.test.reflect.util.ModifierTestUtil;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import junit.framework.Assert;

import java.lang.reflect.Method;

final class ClassMethodStructureDataChecker implements DataChecker {
    private ModifierTestUtil modifierUtil = new DefaultModifierTestUtil();
    private ClassMethodUtil classMethodUtil = new DefaultClassMethodUtil();
    private MethodToStringUtil stringer = new DefaultMethodToStringUtil();

    public void check(Class cls, FieldSpec[] fields) {
        checkMethodSignatures(cls);
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
        fail(method, "violates the constraint that all methods must be public non-static or private.");
    }

    private void checkClassInterface(Class cls, FieldSpec[] fields) {
        Method[] methods = classMethodUtil.getAllNotInheritedPublicInstance(cls);
        if (methods.length <= fields.length) return;
        fail("Too many public methods.  Only getters for the specified properties are allowed.");
    }

    private void checkMethodHasNoArguments(Method method) {
        Class[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length == 0) return;
        fail(method, "has arguments.  All property accessor methods must have no arguments");
    }

    private void fail(Method method, String msg) {
        String name = stringer.toString(method);
        fail(name + " " + msg);
    }

    private void fail(String msg) {
        Assert.fail(msg);
    }
}
