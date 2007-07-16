package au.net.netstorm.boost.test.random;

import java.lang.reflect.Array;
import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.test.field.DefaultFieldSpecTestUtil;
import au.net.netstorm.boost.test.field.FieldSpecTestUtil;
import au.net.netstorm.boost.util.introspect.FieldSpec;

public final class DefaultFieldRandomizer implements FieldRandomizer {
    private FieldSpecTestUtil fielder = new DefaultFieldSpecTestUtil();
    private Provider randomProvider;

    public DefaultFieldRandomizer(Provider randomProvider) {
        this.randomProvider = randomProvider;
    }

    public Object[] getInstances(FieldSpec[] fields) {
        Class[] types = fielder.getTypes(fields);
        Object[] result = new Object[types.length];
        for (int i = 0; i < types.length; i++) {
            result[i] = getInstance(types[i]);
        }
        return result;
    }

    private Object getInstance(Class type) {
        Object instance = randomProvider.provide(type);
        if (type.isArray()) return ensureHasElements(instance, type);
        return instance;
    }

    private Object ensureHasElements(Object instance, Class type) {
        Object newInstance = instance;
        while (Array.getLength(newInstance) == 0) {
            newInstance = randomProvider.provide(type);
        }
        return newInstance;
    }
}