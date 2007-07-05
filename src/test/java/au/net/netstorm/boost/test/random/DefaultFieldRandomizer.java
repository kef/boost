package au.net.netstorm.boost.test.random;

import au.net.netstorm.boost.test.field.DefaultFieldSpecTestUtil;
import au.net.netstorm.boost.test.field.FieldSpecTestUtil;
import au.net.netstorm.boost.util.introspect.FieldSpec;

public final class DefaultFieldRandomizer implements FieldRandomizer {
    private RandomProvider randomProvider;
    private FieldSpecTestUtil fielder = new DefaultFieldSpecTestUtil();

    public DefaultFieldRandomizer(RandomProvider randomProvider) {
        this.randomProvider = randomProvider;
    }

    public Object[] getInstances(FieldSpec[] fields) {
        Class[] types = fielder.getTypes(fields);
        Object[] result = new Object[types.length];
        for (int i = 0; i < types.length; i++) {
            result[i] = randomProvider.provide(types[i]);
        }
        return result;
    }
}
