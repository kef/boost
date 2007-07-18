package au.net.netstorm.boost.test.specific;

import java.util.HashMap;
import java.util.Map;
import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.provider.NotProvidedException;
import au.net.netstorm.boost.provider.ProviderException;

public class DefaultDataProviders extends Primordial implements DataProviders {
    private final Map types = new HashMap();

    public void add(Class type, DataProvider provider) {
        ensureInterface(type);
        types.put(type, provider);
    }

    public boolean canProvide(Class type) {
        return types.containsKey(type);
    }

    public Object provide(Class type) {
        popIfNotSupported(type);
        DataProvider provider = (DataProvider) types.get(type);
        return provider.get();
    }

    private void ensureInterface(Class type) {
        if (!type.isInterface())
            throw new ProviderException("Can only register against interfaces: " + type);
    }

    private void popIfNotSupported(Class type) {
        if (!canProvide(type)) {
            throw new NotProvidedException(type);
        }
    }
}
