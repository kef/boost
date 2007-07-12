package au.net.netstorm.boost.test.specific;

import java.util.HashMap;
import java.util.Map;

public class DefaultSpecifics implements Specifics {
    private final Map types = new HashMap();

    public void add(Class type, TargettedProvider provider) {
        types.put(type, provider);
    }

    public boolean canProvide(Class type) {
        return types.containsKey(type);
    }

    public Object provide(Class type) {
        popIfNotSupported(type);
        TargettedProvider provider = (TargettedProvider) types.get(type);
        return provider.get();
    }

    private void popIfNotSupported(Class type) {
        if (!canProvide(type)) {
            throw new IllegalArgumentException(type + " not supported!");
        }
    }
}
