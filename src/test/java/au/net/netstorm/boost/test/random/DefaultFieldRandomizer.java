package au.net.netstorm.boost.test.random;

import au.net.netstorm.boost.test.DefaultFieldSpecTestUtil;
import au.net.netstorm.boost.test.FieldSpecTestUtil;
import au.net.netstorm.boost.util.introspect.FieldSpec;

public final class DefaultFieldRandomizer implements FieldRandomizer {
    private RandomProvider randomProvider = new EverythingRandomProvider();
    private FieldSpecTestUtil fielder = new DefaultFieldSpecTestUtil();

    // FIX 1676 Split.  These two methods do completely different things.
    public Object[] getInstances(FieldSpec[] fields) {
        Class[] types = fielder.getTypes(fields);
        Object[] result = new Object[types.length];
        for (int i = 0; i < types.length; i++) {
            result[i] = randomProvider.get(types[i]);
        }
        return result;
    }
}