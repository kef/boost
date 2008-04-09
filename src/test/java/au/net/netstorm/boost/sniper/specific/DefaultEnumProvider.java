package au.net.netstorm.boost.sniper.specific;

import java.util.HashMap;
import java.util.Map;
import au.net.netstorm.boost.bullet.primordial.Primordial;

public class DefaultEnumProvider extends Primordial implements EnumProvider {
    private final Map<Class<? extends Enum>, DataProvider<? extends Enum>> enums = new HashMap<Class<? extends Enum>, DataProvider<? extends Enum>>();

    public <T extends Enum> void add(Class<T> type) {
        DataProvider<T> provider = new RandomEnumProvider<T>(type);
        enums.put(type, provider);
    }

    public boolean canProvide(Class<?> type) {
        return enums.containsKey(type);
    }

    public <T> T provide(Class<T> type) {
        DataProvider<? extends Enum> provider = enums.get(type);
        Enum anEnum = provider.get();
        return type.cast(anEnum);
    }
}