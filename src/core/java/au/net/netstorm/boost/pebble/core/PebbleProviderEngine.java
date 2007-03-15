package au.net.netstorm.boost.pebble.core;

// FIX 1715 Change to take Implementation instead of type.
public interface PebbleProviderEngine {
    Object provide(Class type, Object[] parameters);
}
