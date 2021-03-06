package au.net.netstorm.boost.sniper.atom;

import java.lang.reflect.Method;
import au.net.netstorm.boost.gunge.introspect.FieldSpec;
import au.net.netstorm.boost.sledge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;
import au.net.netstorm.boost.sniper.reflect.util.DefaultModifierTestUtil;
import au.net.netstorm.boost.sniper.reflect.util.ModifierTestUtil;
import junit.framework.Assert;

class PropertyMethodStructureChecker implements DataChecker {
    private static final Class[] NO_PARAMETERS = {};
    private ModifierTestUtil modifierUtil = new DefaultModifierTestUtil();
    private MethodToStringUtil stringer = new DefaultMethodToStringUtil();
    private EdgeClass edgeClass = new DefaultEdgeClass();
    private PropertyNameProvider nameProvider = new DefaultPropertyNameProvider();

    public void check(Class cls, FieldSpec[] fields) {
        checkPropertyMethods(cls, fields);
    }

    private void checkPropertyMethods(Class cls, FieldSpec[] fields) {
        for (int i = 0; i < fields.length; i++) {
            checkPropertyMethod(cls, fields[i]);
        }
    }

    private void checkPropertyMethod(Class cls, FieldSpec field) {
        String propertyName = nameProvider.getPropertyMethodName(field);
        Class returnType = field.getType();
        checkMethodExists(cls, propertyName);
        chechMethodSignature(cls, propertyName, returnType);
    }

    private void checkMethodExists(Class cls, String methodName) {
        try {
            cls.getDeclaredMethod(methodName, NO_PARAMETERS);
        } catch (NoSuchMethodException e) {
            fail(methodName, "expected but not found.");
        }
    }

    private void chechMethodSignature(Class cls, String methodName, Class returnType) {
        Method method = edgeClass.getDeclaredMethod(cls, methodName, NO_PARAMETERS);
        checkPublicInstance(method);
        checkReturnType(returnType, method);
    }

    private void checkReturnType(Class expectedType, Method method) {
        Class actualType = method.getReturnType();
        if (actualType.equals(expectedType)) {
            return;
        }
        fail(method, "must return " + expectedType + ".");
    }

    private void checkPublicInstance(Method method) {
        if (modifierUtil.isPublicInstance(method)) {
            return;
        }
        fail(method, "must be a public instance method.");
    }

    private void fail(Method method, String msg) {
        String name = stringer.toString(method);
        barf(name, msg);
    }

    private void fail(String methodName, String msg) {
        String name = stringer.toString(methodName);
        barf(name, msg);
    }

    private void barf(String s1, String s2) {
        Assert.fail(s1 + " " + s2);
    }
}

