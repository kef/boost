package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.test.reflect.util.DefaultModifierTestUtil;
import au.net.netstorm.boost.test.reflect.util.ModifierTestUtil;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import junit.framework.Assert;

import java.lang.reflect.Method;

public class PropertyMethodStructureChecker implements DataChecker {
    private static final Class[] NO_PARAMETERS = {};
    private ModifierTestUtil modifierUtil = new DefaultModifierTestUtil();
    private EdgeClass edgeClass = new DefaultEdgeClass();
    private PropertyNameProvider nameProvider = new DefaultPropertyNameProvider();

    public void check(Class cls, FieldSpec[] fields) {
        checkPropertyMethods(cls, fields);
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
            fail(toString(methodName) + " expected but not found.");
        }
    }

    private void chechMethodSignature(Class cls, String methodName) {
        Method method = edgeClass.getDeclaredMethod(cls, methodName, NO_PARAMETERS);
        if (!modifierUtil.isPublicInstance(method)) fail(toString(methodName) + " must be a public instance method.");
        // FIXME: SC600 check return type.
    }

    private void fail(String msg) {
        Assert.fail(msg);
    }

    private String toString(String methodName) {
        return "Method " + methodName + "()";
    }
}
