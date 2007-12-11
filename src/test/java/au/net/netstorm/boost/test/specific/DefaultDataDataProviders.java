package au.net.netstorm.boost.test.specific;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.provider.ProviderException;
import au.net.netstorm.boost.util.type.Data;

import java.util.HashMap;
import java.util.Map;

public class DefaultDataDataProviders extends Primordial implements DataDataProviders {
    private final Map<Class<? extends Data>, DataProvider<? extends Data>> datas = new HashMap<Class<? extends Data>, DataProvider<? extends Data>>();

    public void add(Class<? extends Data> type, DataProvider<? extends Data> dataProvider) {
        ensureInterface(type);
        datas.put(type, dataProvider);
    }

    public boolean canProvide(Class<?> type) {
        return datas.containsKey(type);
    }

    public <T> T provide(Class<T> type) {
        DataProvider<? extends Data> provider = datas.get(type);
        return (T) provider.get();
    }

    private void ensureInterface(Class type) {
        if (!type.isInterface()) throw new ProviderException("Can only register against interfaces: " + type);
    }
}
