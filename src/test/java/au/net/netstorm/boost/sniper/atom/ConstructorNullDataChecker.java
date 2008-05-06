package au.net.netstorm.boost.sniper.atom;

import au.net.netstorm.boost.bullet.mirror.ClassMaster;
import au.net.netstorm.boost.bullet.mirror.DefaultClassMaster;
import au.net.netstorm.boost.gunge.exception.DefaultThrowableMaster;
import au.net.netstorm.boost.gunge.introspect.FieldSpec;
import au.net.netstorm.boost.gunge.provider.Provider;
import au.net.netstorm.boost.sniper.field.DefaultFieldSpecTestUtil;
import au.net.netstorm.boost.sniper.field.FieldSpecTestUtil;
import au.net.netstorm.boost.sniper.random.DefaultFieldRandomizer;
import au.net.netstorm.boost.sniper.random.FieldRandomizer;
import junit.framework.Assert;

public final class ConstructorNullDataChecker implements DataChecker {
    private InstanceHelper instanceHelper = new DefaultInstanceHelper();
    private PrimitiveBoxer primitiveBoxer = new DefaultPrimitiveBoxer();
    private ClassMaster classMaster = new DefaultClassMaster();
    private FieldSpecTestUtil fielder = new DefaultFieldSpecTestUtil();
    private au.net.netstorm.boost.gunge.exception.ThrowableMaster thrower = new DefaultThrowableMaster();
    private FieldRandomizer fieldUtil;

    public ConstructorNullDataChecker(Provider random) {
        fieldUtil = new DefaultFieldRandomizer(random);
    }

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
        Throwable real = thrower.realCause(throwable);
        if (real instanceof IllegalArgumentException) return;
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
