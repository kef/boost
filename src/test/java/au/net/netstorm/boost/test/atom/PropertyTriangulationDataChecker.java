package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeConstructor;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeConstructor;
import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.reflect.ReflectMaster;
import au.net.netstorm.boost.test.reflect.util.DefaultMethodTestUtil;
import au.net.netstorm.boost.test.reflect.util.MethodTestUtil;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import junit.framework.Assert;

import java.lang.reflect.Constructor;

final class PropertyTriangulationDataChecker implements DataChecker {
    private static final Object[] NO_ARGUMENTS = null;
    private FieldSpecTestUtil fieldSpecUtil = new DefaultFieldSpecTestUtil();
    private PropertyNameProvider nameProvider = new DefaultPropertyNameProvider();
    private TriangulationProvider triangulationProvider = new TestTriangulationProvider();
    private EdgeConstructor edgeConstructor = new DefaultEdgeConstructor();
    private MethodTestUtil methodUtil = new DefaultMethodTestUtil();
    private PrimitiveBoxer primitiveBoxer = new DefaultPrimitiveBoxer();
    private MethodToStringUtil stringer = new DefaultMethodToStringUtil();
    private ReflectMaster reflectMaster = new DefaultReflectMaster();

    public void check(Class cls, FieldSpec[] fields) {
        Object[] values = getInstances(fields);
        Object instance = createInstanceWithValues(cls, values);
        checkPropertyValuesMatch(instance, fields, values);
    }

    private Object createInstanceWithValues(Class cls, Object[] values) {
        return getInstance(cls, values);
    }

    private void checkPropertyValuesMatch(Object instance, FieldSpec[] fields, Object[] values) {
        for (int i = 0; i < fields.length; i++) {
            checkPropertyValueMatches(instance, fields[i], values[i]);
        }
    }

    private void checkPropertyValueMatches(Object instance, FieldSpec field, Object value) {
        String methodName = nameProvider.getPropertyMethodName(field);
        Object returnValue = methodUtil.invoke(instance, methodName, NO_ARGUMENTS);
        checkEquals(value, returnValue, methodName);
    }

    // FIX SC600 This is where array checking would scoot off somewhere else.
    private void checkEquals(Object value, Object returnValue, String methodName) {
        if (equals(value, returnValue)) return;
        fail(methodName, "should return the same value as passed in to the constructor.  Instead it returned (" + returnValue + ").");
    }

    // FIX SC600 Smells like an equals checker.
    private boolean equals(Object value, Object returnValue) {
        boolean boxed = isBoxed(value);
        if (boxed) return value.equals(returnValue);
        return value == returnValue;
    }

    private Object getInstance(Class cls, Object[] parameters) {
        Constructor constructor = reflectMaster.getConstructor(cls);
        return getInstance(constructor, parameters);
    }

    private Object[] getInstances(FieldSpec[] fields) {
        Class[] classes = fieldSpecUtil.getTypes(fields);
        return triangulationProvider.getInstances(classes);
    }

    private Object getInstance(Constructor constructor, Object[] parameters) {
        constructor.setAccessible(true);
        return edgeConstructor.newInstance(constructor, parameters);
    }

    private boolean isBoxed(Object value) {
        Class cls = value.getClass();
        return primitiveBoxer.isBoxed(cls);
    }

    private void fail(String methodName, String msg) {
        String name = stringer.toString(methodName);
        Assert.fail(name + " " + msg);
    }
}
