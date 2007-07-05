package au.net.netstorm.boost.test.specific;

import java.util.HashMap;
import java.util.Map;

public class DefaultSpecificProviderRegistry implements SpecificProviderRegistry {
    private Map types = new HashMap();

    public void add(Class type, SpecificProvider provider) {
        types.put(type, provider);
    }

    public boolean contains(Class type) {
        return types.containsKey(type);
    }

    public Object get(Class type) {
        popIfNotSupported(type);
        SpecificProvider provider = (SpecificProvider) types.get(type);
        return provider.get();
    }

    private void popIfNotSupported(Class type) {
        if (!contains(type)) {
            throw new IllegalArgumentException(type + " not supported!");
        }
    }
}
