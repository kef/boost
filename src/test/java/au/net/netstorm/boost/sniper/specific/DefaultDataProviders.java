package au.net.netstorm.boost.sniper.specific;

import java.util.HashMap;
import java.util.Map;
import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.bullet.provider.ProviderException;
import au.net.netstorm.boost.gunge.type.Data;

public class DefaultDataProviders extends Primordial implements DataProviders {
    private final Map<Class<? extends Data>, DataProvider<? extends Data>> datas = new HashMap<Class<? extends Data>, DataProvider<? extends Data>>();

    public <T extends Data> void add(Class<T> type, DataProvider provider) {
        ensureInterface(type);
        datas.put(type, provider);
    }

    public boolean canProvide(Class<?> type) {
        return datas.containsKey(type);
    }

    public <T> T provide(Class<T> type) {
        DataProvider<? extends Data> provider = datas.get(type);
        Data data = provider.get();
        return type.cast(data);
    }

    private void ensureInterface(Class type) {
        if (!type.isInterface()) throw new ProviderException("Can only register against interfaces: " + type);
    }
}
