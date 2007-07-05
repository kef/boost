package au.net.netstorm.boost.test.random;

import java.lang.reflect.Array;

public final class ArrayRandomProvider implements RandomProvider {
    private final RandomProvider randomProvider;

    public ArrayRandomProvider(RandomProvider randomProvider) {
        this.randomProvider = randomProvider;
    }

    public Object provide(Class type) {
        Class componentType = type.getComponentType();
        int size = randomSize();
        Object array = Array.newInstance(componentType, size);
        populate(size, componentType, array);
        return array;
    }

    private void populate(int size, Class componentType, Object array) {
        for (int i = 0; i < size; i++) {
            Object instance = randomProvider.provide(componentType);
            Array.set(array, i, instance);
        }
    }

    private int randomSize() {
        Boolean on = (Boolean) randomProvider.provide(Boolean.class);
        return on ? 2 : 3;
    }
}
