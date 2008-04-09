package au.net.netstorm.boost.sniper.specific;

import java.util.Random;

public class RandomEnumProvider<T extends Enum> implements DataProvider<T> {
    private static final Random RANDOM = new Random();
    private final Class<T> cls;

    public RandomEnumProvider(Class<T> cls) {
        this.cls = cls;
    }

    public T get() {
        T[] values = cls.getEnumConstants();
        int i = RANDOM.nextInt(values.length);
        return values[i];
    }
}
