package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;
import junit.framework.Assert;

final class NonArrayPropertyTriangulationChecker implements TriangulationChecker {
    private PrimitiveBoxer primitiveBoxer = new DefaultPrimitiveBoxer();
    private MethodToStringUtil stringer = new DefaultMethodToStringUtil();
    private InstanceHelper instanceHelper = new DefaultInstanceHelper();
    private PropertyAccessor propertyAccessor = new DefaultPropertyAccessor();
    private FieldSpecTestUtil fieldUtil = new DefaultFieldSpecTestUtil();
    private PropertyNameProvider nameProvider = new DefaultPropertyNameProvider();

    public void check(Class cls, Object[] parameters, FieldSpec candidate, int position) {
        Object instance = getInstance(cls, parameters);
        checkPropertyValueMatches(instance, candidate, parameters[position]);
    }

    private void checkPropertyValueMatches(Object instance, FieldSpec field, Object value) {
        Object returnValue = propertyAccessor.invoke(instance, field);
        checkEquals(value, returnValue, field);
    }

    private void checkEquals(Object value, Object returnValue, FieldSpec field) {
        if (equals(value, returnValue)) return;
        fail(field, "should return the same value as passed in to the constructor.  Instead it returned (" + returnValue + ").");
    }

    private boolean equals(Object value, Object returnValue) {
        boolean boxed = isBoxed(value);
        if (boxed) return value.equals(returnValue);
        return value == returnValue;
    }

    private Object getInstance(Class cls, Object[] values) {
        return instanceHelper.getInstance(cls, values);
    }

    private boolean isBoxed(Object value) {
        Class cls = value.getClass();
        return primitiveBoxer.isBoxed(cls);
    }

    private void fail(FieldSpec field, String msg) {
        String methodName = nameProvider.getPropertyMethodName(field);
        String name = stringer.toString(methodName);
        Assert.fail(name + " " + msg);
    }
}
