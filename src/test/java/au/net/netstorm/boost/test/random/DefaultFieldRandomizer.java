package au.net.netstorm.boost.test.random;

import au.net.netstorm.boost.test.field.DefaultFieldSpecTestUtil;
import au.net.netstorm.boost.test.field.FieldSpecTestUtil;
import au.net.netstorm.boost.util.introspect.FieldSpec;

public final class DefaultFieldRandomizer implements FieldRandomizer {
    private RandomProvider randomProvider = new EverythingRandomProvider();
    private FieldSpecTestUtil fielder = new DefaultFieldSpecTestUtil();

    public Object[] getInstances(FieldSpec[] fields) {
        Class[] types = fielder.getTypes(fields);
        Object[] result = new Object[types.length];
        for (int i = 0; i < types.length; i++) {
            result[i] = randomProvider.get(types[i]);
        }
        return result;
    }
}
