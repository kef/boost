package au.net.netstorm.boost.test.specific;

import java.util.HashMap;
import java.util.Map;

public class DefaultSpecificProviderRegistry implements SpecificProviderRegistry {
    private final Map types = new HashMap();

    public void add(Class type, SpecificProvider provider) {
        types.put(type, provider);
    }

    public boolean canProvide(Class type) {
        return types.containsKey(type);
    }

    public Object provide(Class type) {
        popIfNotSupported(type);
        SpecificProvider provider = (SpecificProvider) types.get(type);
        return provider.get();
    }

    private void popIfNotSupported(Class type) {
        if (!canProvide(type)) {
            throw new IllegalArgumentException(type + " not supported!");
        }
    }
}
