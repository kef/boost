package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.reflect.ClassMaster;
import au.net.netstorm.boost.reflect.DefaultClassMaster;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import junit.framework.Assert;

final class ConstructorNullDataChecker implements DataChecker {
    private InstanceHelper instanceHelper = new DefaultInstanceHelper();
    private PrimitiveBoxer primitiveBoxer = new DefaultPrimitiveBoxer();
    private FieldSpecTestUtil fieldUtil = new DefaultFieldSpecTestUtil();
    private ExceptionUtil exceptionUtil = new DefaultExceptionUtil();
    private ClassMaster classMaster = new DefaultClassMaster();

    public void check(Class cls, FieldSpec[] fields) {
        Object[] parameters = instanceHelper.getInstances(fields);
        Class[] types = fieldUtil.getTypes(fields);
        checkNullsAreBumped(cls, parameters, types);
        // FIX SC600 BREADCRUMB Complete.
    }

    private void checkNullsAreBumped(Class cls, Object[] parameters, Class[] types) {
        for (int i = 0; i < parameters.length; i++) {
            checkNullIsBumped(cls, parameters, types[i], i);
        }
    }

    // FIX SC600 BREADCRUMB Tidy this.
    private void checkNullIsBumped(Class cls, Object[] parameters, Class type, int i) {
        if (isPrimitive(type)) return;
        Object[] oneNulled = nullParameterOut(parameters, i);
        try {
            instanceHelper.getInstance(cls, oneNulled);
            fail(type, i);
        } catch (Throwable t) {
            boolean bumped = exceptionUtil.threw(t, IllegalArgumentException.class);
            if (bumped) return;
            fail(type, i);
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

    private void fail(Class type, int i) {
        String shortName = classMaster.getShortName(type);
        Assert.fail("We do not allow nulls in Data atoms.  You must throw an IllegalArgumentException when parameter (" + shortName + ") at position " + i + " in the constructor is null.");
    }
}
