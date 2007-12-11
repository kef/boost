package au.net.netstorm.boost.test.specific;

import au.net.netstorm.boost.primordial.Primordial;

import java.util.HashMap;
import java.util.Map;

public class DefaultEnumDataProviders extends Primordial implements EnumDataProviders {
    private final Map<Class<? extends Enum>, DataProvider<? extends Enum>> enums = new HashMap<Class<? extends Enum>, DataProvider<? extends Enum>>();

    public void add(Class<? extends Enum> type, DataProvider<? extends Enum> dataProvider) {
        enums.put(type, dataProvider);
    }

    public boolean canProvide(Class<?> type) {
        return enums.containsKey(type);
    }

    public <T> T provide(Class<T> type) {
        DataProvider<? extends Enum> provider = enums.get(type);
        return (T) provider.get();
    }
}