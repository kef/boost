package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;

final class ConstructorNullDataChecker implements DataChecker {
    private InstanceHelper instanceHelper = new DefaultInstanceHelper();
    private PrimitiveBoxer primitiveBoxer = new DefaultPrimitiveBoxer();
    private FieldSpecTestUtil fieldUtil = new DefaultFieldSpecTestUtil();

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
        boolean primitive = primitiveBoxer.isPrimitive(types[i]);
        if (primitive) return;
        Object[] oneNulled = nullParameterOut(parameters, i);
        // FIX SC600 Ignore if primitive type.
        // FIX SC600 BREADCRUMB This should fail.
        instanceHelper.getInstance(cls, oneNulled);
    }

    private Object[] nullParameterOut(Object[] parameters, int i) {
        Object[] result = (Object[]) parameters.clone();
        result[i] = null;
        return result;
    }
}
