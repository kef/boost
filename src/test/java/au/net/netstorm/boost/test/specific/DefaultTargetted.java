package au.net.netstorm.boost.test.specific;

import java.util.HashMap;
import java.util.Map;
import au.net.netstorm.boost.util.type.DefaultInterface;

public class DefaultTargetted implements Targetted {
    private final Map types = new HashMap();

    public void add(Class type, TargettedProvider provider) {
        constrain(type);
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

    private void constrain(Class type) {
        // FIX 2076 nice message
        new DefaultInterface(type);
    }

    private void popIfNotSupported(Class type) {
        if (!canProvide(type)) {
            throw new IllegalArgumentException(type + " not supported!");
        }
    }
}
