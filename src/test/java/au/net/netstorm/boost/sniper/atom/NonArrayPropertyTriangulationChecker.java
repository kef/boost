package au.net.netstorm.boost.sniper.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;
import junit.framework.Assert;

final class NonArrayPropertyTriangulationChecker implements TriangulationChecker {
    private MethodToStringUtil stringer = new DefaultMethodToStringUtil();
    private InstanceHelper instanceHelper = new DefaultInstanceHelper();
    private PropertyAccessor propertyAccessor = new DefaultPropertyAccessor();
    private PropertyNameProvider nameProvider = new DefaultPropertyNameProvider();
    private SameHelper sameHelper = new DefaultSameHelper();

    public void check(Class cls, Object[] parameters, FieldSpec candidate, Object parameter) {
        Object instance = getInstance(cls, parameters);
        checkPropertyValueMatches(instance, candidate, parameter);
    }

    private void checkPropertyValueMatches(Object instance, FieldSpec field, Object parameter) {
        Object returnValue = propertyAccessor.invoke(instance, field);
        checkEquals(parameter, returnValue, field);
    }

    private void checkEquals(Object value, Object returnValue, FieldSpec field) {
        if (equals(value, returnValue)) return;
        fail(field, "should return the same value as passed in to the constructor.  Instead it returned (" + returnValue + ").");
    }

    private boolean equals(Object value, Object returnValue) {
        return sameHelper.same(value, returnValue);
    }

    private Object getInstance(Class cls, Object[] values) {
        return instanceHelper.getInstance(cls, values);
    }

    private void fail(FieldSpec field, String msg) {
        String methodName = nameProvider.getPropertyMethodName(field);
        String name = stringer.toString(methodName);
        Assert.fail(name + " " + msg);
    }
}
