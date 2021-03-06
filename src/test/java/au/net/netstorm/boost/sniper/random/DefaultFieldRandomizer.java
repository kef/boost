package au.net.netstorm.boost.sniper.random;

import au.net.netstorm.boost.gunge.introspect.FieldSpec;
import au.net.netstorm.boost.gunge.provider.Provider;
import au.net.netstorm.boost.sniper.field.DefaultFieldSpecTestUtil;
import au.net.netstorm.boost.sniper.field.FieldSpecTestUtil;

public final class DefaultFieldRandomizer implements FieldRandomizer {
    private Provider randomProvider;
    private FieldSpecTestUtil fielder = new DefaultFieldSpecTestUtil();

    public DefaultFieldRandomizer(Provider randomProvider) {
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
