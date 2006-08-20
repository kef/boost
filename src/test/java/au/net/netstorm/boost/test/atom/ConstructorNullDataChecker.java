package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;
import junit.framework.Assert;

final class ConstructorNullDataChecker implements DataChecker {
    private InstanceHelper instanceHelper = new DefaultInstanceHelper();
    private PrimitiveBoxer primitiveBoxer = new DefaultPrimitiveBoxer();
    private FieldSpecTestUtil fieldUtil = new DefaultFieldSpecTestUtil();
    private ExceptionUtil exceptionUtil = new DefaultExceptionUtil();

    public void check(Class cls, FieldSpec[] fields) {
        Object[] parameters = instanceHelper.getInstances(fields);
        Class[] types = fieldUtil.getTypes(fields);
        checkNullsAreBumped(cls, parameters, types);
        // FIX SC600 BREADCRUMB Complete.
    }

    private void checkNullsAreBumped(Class cls, Object[] parameters, Class[] types) {
        for (int i = 0; i < parameters.length; i++) {
            checkNullIsBumped(cls, parameters, types, i);
        }
    }

    private void checkNullIsBumped(Class cls, Object[] parameters, Class[] types, int i) {
        if (isPrimitive(types[i])) return;
        Object[] oneNulled = nullParameterOut(parameters, i);
        try {
            instanceHelper.getInstance(cls, oneNulled);
            fail(i);
        } catch (Throwable t) {
            boolean bumped = exceptionUtil.threw(t, IllegalArgumentException.class);
            if (bumped) return;
            fail(i);
        }
    }

    private Object[] nullParameterOut(Object[] parameters, int i) {
        Object[] result = (Object[]) parameters.clone();
        result[i] = null;
        return result;
    }

    private boolean isPrimitive(Class type) {
        return primitiveBoxer.isPrimitive(type);
    }

    private void fail(int i) {
        Assert.fail("Constructor parameter at position " + i + " can be null.  We do not allow nulls.");
    }
}
