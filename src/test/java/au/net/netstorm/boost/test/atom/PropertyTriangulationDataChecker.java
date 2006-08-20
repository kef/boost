package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.test.reflect.util.DefaultMethodTestUtil;
import au.net.netstorm.boost.test.reflect.util.MethodTestUtil;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import junit.framework.Assert;

final class PropertyTriangulationDataChecker implements DataChecker {
    private static final Object[] NO_ARGUMENTS = null;
    private PropertyNameProvider nameProvider = new DefaultPropertyNameProvider();
    private MethodTestUtil methodUtil = new DefaultMethodTestUtil();
    private PrimitiveBoxer primitiveBoxer = new DefaultPrimitiveBoxer();
    private MethodToStringUtil stringer = new DefaultMethodToStringUtil();
    private InstanceHelper instanceHelper = new DefaultInstanceHelper();
    private FieldSpecTestUtil fieldUtil = new DefaultFieldSpecTestUtil();

    public void check(Class cls, FieldSpec[] fields) {
        Object[] parameters = getInstances(fields);
        Object instance = getInstance(cls, parameters);
        checkPropertyValuesMatch(instance, fields, parameters);
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

    // SUGGEST This is where array checking would scoot off somewhere else.
    private void checkEquals(Object value, Object returnValue, String methodName) {
        if (equals(value, returnValue)) return;
        fail(methodName, "should return the same value as passed in to the constructor.  Instead it returned (" + returnValue + ").");
    }

    private Object[] getInstances(FieldSpec[] fields) {
        return fieldUtil.getInstances(fields);
    }

    private Object getInstance(Class cls, Object[] values) {
        return instanceHelper.getInstance(cls, values);
    }

    // FIX SC6µ00 BREADCRUMB Move the equals out.
    // FIX SC600 Smells like a equals/same checker.
    private boolean equals(Object value, Object returnValue) {
        boolean boxed = isBoxed(value);
        if (boxed) return value.equals(returnValue);
        return value == returnValue;
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
