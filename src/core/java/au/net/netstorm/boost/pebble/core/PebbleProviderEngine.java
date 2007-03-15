package au.net.netstorm.boost.pebble.core;

public interface PebbleProviderEngine {
    Object provide(Class type, Object[] parameters);
}
