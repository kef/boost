package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;
import junit.framework.Assert;

import java.lang.reflect.Array;

final class ArrayPropertyTriangulationChecker implements TriangulationChecker {
    private static final String ARRAYS_NOTE = "Arrays must be copied on create and on each access.  Try using arrayRef.clone().";
    private InstanceHelper instanceHelper = new DefaultInstanceHelper();
    private PropertyAccessor propertyAccessor = new DefaultPropertyAccessor();
    private SameHelper sameHelper = new DefaultSameHelper();

    public void check(Class cls, Object[] parameters, FieldSpec candidate, Object parameter) {
        Object instance = instanceHelper.getInstance(cls, parameters);
        checkCopyOnAccess(instance, candidate, parameter);
        checkCopyOnCreate(instance, candidate, parameter);
    }

    private void checkCopyOnAccess(Object instance, FieldSpec candidate, Object parameter) {
        Object r1 = invoke(instance, candidate);
        checkEqualButDifferentReferences(parameter, r1);
        Object r2 = invoke(instance, candidate);
        checkEqualButDifferentReferences(r1, r2);
    }

    private void checkCopyOnCreate(Object instance, FieldSpec candidate, Object parameter) {
        Object expected = cloneArray(parameter);
        munge(parameter);  // Remember the object has been created by this stage.  We are trying to rip out the rug.
        Object returnValue = invoke(instance, candidate);
        if (same(expected, returnValue)) return;
        fail("Array was not copied on create.");
    }

    // FIX 525 Move to array helper.
    private Object cloneArray(Object array) {
        int length = Array.getLength(array);
        Object firstElement = Array.get(array, 0); // FIX 525 There is another way of doing this.
        Class type = firstElement.getClass();
        Object result = Array.newInstance(type, length);
        for (int i = 0; i < length; i++) {
            Object value = Array.get(array, i);
            Array.set(result, i, value);
        }
        return result;
    }

    private void checkEqualButDifferentReferences(Object expected, Object actual) {
        checkDifferentReferences(expected, actual);
        checkSameElements(expected, actual);
    }

    private void checkDifferentReferences(Object o1, Object o2) {
        if (o1 != o2) return;
        fail("Array was not copied on access.");
    }

    private void checkSameElements(Object expected, Object actual) {
        if (same(expected, actual)) return;
        fail("Elements of array not the same.");
    }

    private void munge(Object parameters) {
        Object value = Array.get(parameters, 1);
        Array.set(parameters, 0, value);
    }

    private Object invoke(Object instance, FieldSpec candidate) {
        return propertyAccessor.invoke(instance, candidate);
    }

    private boolean same(Object expected, Object actual) {
        return sameHelper.same(expected, actual);
    }

    private void fail(String msg) {
        Assert.fail(msg + "  " + ARRAYS_NOTE);
    }
}
