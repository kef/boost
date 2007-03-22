package au.net.netstorm.boost.test.atom;

import java.lang.reflect.Array;

public final class DefaultArrayRandomProvider implements RandomProvider {
    private static final int ARRAY_LENGTH = 5;
    private final RandomProvider randomProvider;

    public DefaultArrayRandomProvider(RandomProvider randomProvider) {
        this.randomProvider = randomProvider;
    }

    public Object get(Class type) {
        Class componentType = type.getComponentType();
        Object array = Array.newInstance(componentType, ARRAY_LENGTH);
        populate(array, componentType);
        return array;
    }

    private void populate(Object array, Class type) {
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            Object instance = randomProvider.get(type);
            Array.set(array, i, instance);
        }
    }
}
