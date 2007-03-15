package au.net.netstorm.boost.pebble.core;

import au.net.netstorm.boost.pebble.type.Implementation;

public interface PebbleProviderEngine {
    Object provide(Implementation implementation, Object[] parameters);
}
