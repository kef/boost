package au.net.netstorm.boost.pebble.core;

import au.net.netstorm.boost.pebble.type.Implementation;

// FIX 1715 Change to take Implementation instead of type.
public interface PebbleProviderEngine {
    Object provide(Implementation implementation, Object[] parameters);
}
