package au.net.netstorm.boost.pebble.core;

import au.net.netstorm.boost.pebble.type.DefaultImplementation;
import au.net.netstorm.boost.pebble.type.Implementation;

public final class DefaultPebbleProvider implements PebbleProvider {
    private final NewPebbleProviderEngine engine;

    public DefaultPebbleProvider(NewPebbleProviderEngine engine) {
        this.engine = engine;
    }

    public Object provide(Class type, Object[] parameters) {
        Implementation implementation = new DefaultImplementation(type);
        return engine.provider(implementation, parameters);
    }
}
