package au.net.netstorm.boost.test.random;

import java.lang.reflect.Array;
import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.test.field.DefaultFieldSpecTestUtil;
import au.net.netstorm.boost.test.field.FieldSpecTestUtil;
import au.net.netstorm.boost.util.introspect.FieldSpec;

public final class DefaultFieldRandomizer implements FieldRandomizer {
    private static final int ARRAY_LENGTH = 2;
    private FieldSpecTestUtil fielder = new DefaultFieldSpecTestUtil();
    private Provider randomProvider;

    public DefaultFieldRandomizer(Provider randomProvider) {
        this.randomProvider = randomProvider;
    }

    public Object[] getInstances(FieldSpec[] fields) {
        Class[] types = fielder.getTypes(fields);
        Object[] result = new Object[types.length];
        for (int i = 0; i < types.length; i++) {
            if (types[i].isArray()) {
                result[i] = createArray(types[i]);
            } else {
                result[i] = randomProvider.provide(types[i]);
            }
        }
        return result;
    }

    // FIX BREADCRUMB 2076 This is an ugly wart to get around a random array provider returning 0 - 2 array length.
    // Need at least 2 elements to avoid munging munge() in ArrayPropertyTriangulationChecker
    private Object createArray(Class type) {
        Class componentType = type.getComponentType();
        Object array = Array.newInstance(componentType, ARRAY_LENGTH);
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            addElement(componentType, array, i);
        }
        return array;
    }

    private void addElement(Class componentType, Object array, int i) {
        Object element = randomProvider.provide(componentType);
        Array.set(array, i, element);
    }
}