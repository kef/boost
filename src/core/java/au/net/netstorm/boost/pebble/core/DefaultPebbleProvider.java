package au.net.netstorm.boost.pebble.core;

import au.net.netstorm.boost.util.type.DefaultImplementation;
import au.net.netstorm.boost.util.type.Implementation;

public final class DefaultPebbleProvider implements PebbleProvider {
    private final PebbleProviderEngine engine;

    public DefaultPebbleProvider(PebbleProviderEngine engine) {
        this.engine = engine;
    }

    public Object provide(Class type, Object[] parameters) {
        Implementation implementation = new DefaultImplementation(type);
        return engine.provide(implementation, parameters);
    }
}
