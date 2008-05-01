package au.net.netstorm.boost.sniper.random;

import java.lang.reflect.Array;
import au.net.netstorm.boost.bullet.provider.NotProvidedException;
import au.net.netstorm.boost.bullet.provider.Provider;
import au.net.netstorm.boost.bullet.provider.SpecificProvider;

public final class ArrayRandomProvider implements SpecificProvider {
    private final Provider randomProvider;

    public ArrayRandomProvider(Provider randomProvider) {
        this.randomProvider = randomProvider;
    }

    public <T> T provide(Class<T> type) {
        if (!canProvide(type)) throw new NotProvidedException(type);
        Class componentType = type.getComponentType();
        int size = randomSize();
        T array = (T) Array.newInstance(componentType, size);
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
        Boolean on = randomProvider.provide(Boolean.class);
        return on ? 4 : 5;
    }
}