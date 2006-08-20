package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;
import junit.framework.Assert;

final class ArrayPropertyTriangulationChecker implements TriangulationChecker {
    private InstanceHelper instanceHelper = new DefaultInstanceHelper();
    private PropertyAccessor propertyAccessor = new DefaultPropertyAccessor();

    // FIX SC600 Hard fail on Arrays containing arrays.  We do not support them.
    public void check(Class cls, Object[] parameters, FieldSpec candidate, int position) {
        Object instance = instanceHelper.getInstance(cls, parameters);
        checkCopyOnAccess(instance, parameters, candidate, position);
        // FIX SC600 Check copy on creation.
        // FIX SC600 Check copy on property access.
        // FIX SC600 Must be different references.
        // FIX SC600 Contents must be the same.
        // FIX SC600 Subsequent calls should yield a different value.
        // FIX SC600 BREADCRUMB Finish this off.
    }

    private void checkCopyOnAccess(Object instance, Object[] parameters, FieldSpec candidate, int position) {
        Object[] r1 = invoke(instance, candidate);
        Object[] expected = getParameter(parameters, position);
        checkEqualButDifferentReferences(expected, r1);
    }

    private void checkEqualButDifferentReferences(Object[] expected, Object[] actual) {
        checkDifferentReferences(expected, actual);
        checkSameElements(expected, actual);
    }

    private void checkDifferentReferences(Object o1, Object o2) {
        if (o1 != o2) return;
        // FIX SC600 Fix this message.
        fail("MUST COPY ON ACCESSOR (FIX THIS MESSAGE");
    }

    private void checkSameElements(Object[] expected, Object[] actual) {
        // FIX SC600 BREADCRUMB 
        // FIX SC600 Complete.
    }

    private Object[] invoke(Object instance, FieldSpec candidate) {
        return (Object[]) propertyAccessor.invoke(instance, candidate);
    }

    private Object[] getParameter(Object[] parameters, int position) {
        return (Object[]) parameters[position];
    }

    private void fail(String msg) {
        Assert.fail(msg);
    }
}
