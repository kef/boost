package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.reflect.ClassMaster;
import au.net.netstorm.boost.reflect.DefaultClassMaster;
import au.net.netstorm.boost.test.DefaultFieldSpecTestUtil;
import au.net.netstorm.boost.test.FieldSpecTestUtil;
import au.net.netstorm.boost.test.random.DefaultFieldRandomizer;
import au.net.netstorm.boost.test.random.FieldRandomizer;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import junit.framework.Assert;

public final class ConstructorNullDataChecker implements DataChecker {
    private InstanceHelper instanceHelper = new DefaultInstanceHelper();
    private PrimitiveBoxer primitiveBoxer = new DefaultPrimitiveBoxer();
    private FieldRandomizer fieldUtil = new DefaultFieldRandomizer();
    private ExceptionUtil exceptionUtil = new DefaultExceptionUtil();
    private ClassMaster classMaster = new DefaultClassMaster();
    private FieldSpecTestUtil fielder = new DefaultFieldSpecTestUtil();

    public void check(Class cls, FieldSpec[] fields) {
        Object[] parameters = getInstances(fields);
        Class[] types = fielder.getTypes(fields);
        checkNullsAreBumped(cls, parameters, types);
    }

    private void checkNullsAreBumped(Class cls, Object[] parameters, Class[] types) {
        for (int i = 0; i < parameters.length; i++) {
            checkNullIsBumped(cls, parameters, types[i], i);
        }
    }

    private void checkNullIsBumped(Class cls, Object[] parameters, Class type, int i) {
        if (isPrimitive(type)) return;
        checkNullIsBumpedForNonPrimitive(cls, parameters, type, i);
    }

    private void checkNullIsBumpedForNonPrimitive(Class cls, Object[] parameters, Class type, int i) {
        Object[] oneNulled = nullParameterOut(parameters, i);
        try {
            getInstance(cls, oneNulled);
            fail(type, i);
        } catch (Throwable t) {
            checkBumpedNull(t, type, i);
        }
    }

    private void checkBumpedNull(Throwable throwable, Class type, int i) {
        if (exceptionUtil.threw(throwable, IllegalArgumentException.class)) return;
        fail(type, i);
    }

    private void getInstance(Class cls, Object[] oneNulled) {
        instanceHelper.getInstance(cls, oneNulled);
    }

    private Object[] getInstances(FieldSpec[] fields) {
        return fieldUtil.getInstances(fields);
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
        Assert.fail("We do not allow nulls in Data atoms.  You must throw an IllegalArgumentException when parameter ("
                + shortName + ") at position " + i + " in the constructor is null.");
    }
}
