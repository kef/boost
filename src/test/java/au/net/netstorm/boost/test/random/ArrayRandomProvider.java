package au.net.netstorm.boost.test.random;

import java.lang.reflect.Array;
import au.net.netstorm.boost.provider.NotProvidedException;
import au.net.netstorm.boost.provider.Provider;
import au.net.netstorm.boost.provider.SpecificProvider;

public final class ArrayRandomProvider implements SpecificProvider {
    private final Provider randomProvider;

    public ArrayRandomProvider(Provider randomProvider) {
        this.randomProvider = randomProvider;
    }

    public Object provide(Class type) {
        if (!canProvide(type)) throw new NotProvidedException(type);
        Class componentType = type.getComponentType();
        int size = randomSize();
        Object array = Array.newInstance(componentType, size);
        populate(size, componentType, array);
        return array;
    }

    public boolean canProvide(Class type) {
        return type.isArray();
    }

    private void populate(int size, Class componentType, Object array) {
        for (int i = 0; i < size; i++) {
            Object instance = randomProvider.provide(componentType);
            Array.set(array, i, instance);
        }
    }

    private int randomSize() {
        Boolean on = (Boolean) randomProvider.provide(Boolean.class);
        return on ? 0 : 2;
    }
}
