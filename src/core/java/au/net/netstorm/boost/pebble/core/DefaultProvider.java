package au.net.netstorm.boost.pebble.core;

import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Instance;

public final class DefaultProvider implements Provider {
    private final PebbleProviderEngine engine;

    public DefaultProvider(PebbleProviderEngine engine) {
        this.engine = engine;
    }

    // FIX 32755 Can we get people to deal directly with the "engine"
    public Object provide(Class type, Object[] parameters) {
        Implementation implementation = new DefaultImplementation(type);
        Instance instance = engine.provide(implementation, parameters);
        return instance.getRef();
    }
}
